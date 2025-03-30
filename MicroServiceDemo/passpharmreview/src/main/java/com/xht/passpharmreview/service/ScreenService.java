package com.xht.passpharmreview.service;

import com.xht.passpharmreview.cache.localcache.caffine.CaffeineLocalCache;
import com.xht.passpharmreview.cachemanager.task.TaskManager;
import com.xht.passpharmreview.model.screen.cachemodel.TaskAllCacheModel;
import com.xht.passpharmreview.model.screen.inputmodel.JsonDataModel;
import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
import com.xht.passpharmreview.model.screen.outputmodel.ScreenResultOutput;
import com.xht.passpharmreview.utils.TimeUtils;
import com.xht.projectcommom.feignapi.coreapi.CoreScreenService;
import com.xht.projectcommom.feignapi.uqidapi.UqIdService;
import com.xht.projectcommom.util.jsonutil.JsonUtils;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: ScreenService
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/24 15:11
 * @Version: V1.0
 */
@Service
public class ScreenService {
    private  final String HOSP_ID_REG = "\"HospID\":\"(\\w+)\"";

    private final int overTime = 30;

    @Autowired
    CoreScreenService coreScreenService;

    @Autowired
    RedisOpsExtUtil redisOpsExtUtil;

    @Autowired
    UqIdService uqIdService;
    @Autowired
    TaskManager taskManager;

    @Autowired
    CaffeineLocalCache<String, TaskListCacheModel> localCache;
    private static final Map<String, Integer> map = new HashMap<>();

    private static final Map<String, Integer> doctorMap = new HashMap<>();

    public ScreenService() {
        map.put("hiscode00001", 1);
        map.put("hiscode00002", 2);
        map.put("hiscode00003", 3);
        map.put("hiscode00004", 4);
        map.put("hiscode00005", 5);
        map.put("hiscode00006", 6);
        map.put("hiscode00007", 7);
        map.put("hiscode00008", 8);
        map.put("hiscode00009", 9);
        map.put("hiscode000010", 10);
        map.put("hiscode000011", 11);

        doctorMap.put("KZYS005",1);
    }

    public String screenViewWithPreRequest(String input) {
        //1.拿到hospid 分片键。
        String hisCode = "";

        Pattern patternHospId = Pattern.compile(HOSP_ID_REG);
        Matcher matcherHospId = patternHospId.matcher(input);

        if (matcherHospId.find()) {
            hisCode = matcherHospId.group(1);
        }
        //2.调用core进行审查，获得结果串，这里在core模块里面用sleep来模拟耗时。
        //可以构建几个假的结果串，随机取一个当做结果。
        String screenResStr = coreScreenService.screenWithJsonStr(input);
        //找到mhiscode
        Integer mHisCode = map.get(hisCode);
        String mHisCodeStr = mHisCode.toString();
        String mHisCodeTail = mHisCode < 10 ? "0" + mHisCodeStr
                : mHisCodeStr.substring(mHisCodeStr.length() - 2);

        //3.放入多级缓存中。redis+本地缓存。
        String uqTaskId = uqIdService.getSegmentId("pr_task_id");

        Long taskIdLong = Long.valueOf(uqTaskId + mHisCodeTail);
        JsonDataModel jsonData = JsonUtils.toObject(input, JsonDataModel.class);

        ScreenResultOutput outputData = JsonUtils.toObject(screenResStr, ScreenResultOutput.class);

        //生成一个vercaseid、caseid

        //这里是否应该构建一个TaskAllCache对象，包含任务对应的所有信息，然而如果存入redis中，
        // 则只需要新任务列表上的这些字段？数据库则对应taskinfo和taskinfohistory表
        //其实也不需要，这里只需要保证taskinfo表和缓存一致就行了。history可以单独放队列里面去执行。

        //暂时先不管：能否优化，搞2个redis集群，第一个只存任务的基本信息，第二个则存任务所有的信息。
        // 第二个基本上用不到，只是在本地缓存找不到之后，才去redsi拉取？
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowTimeStr = LocalDateTime.now().format(formatter);

        TaskAllCacheModel taskAllCacheModel = new TaskAllCacheModel();
        taskAllCacheModel.setTaskId(taskIdLong);
        taskAllCacheModel.setVerCaseId("");
        taskAllCacheModel.setJsonDataModel(jsonData);
        taskAllCacheModel.setScreenResultOutputModel(outputData);

        TaskListCacheModel taskListCacheModel = new TaskListCacheModel();
        taskListCacheModel.setTaskId(taskIdLong);
        taskListCacheModel.setDoctorId(doctorMap.get(jsonData.getPatient().getDoctorCode()));
        taskListCacheModel.setUserId(0);
        taskListCacheModel.setMHisCode(mHisCode);
        taskListCacheModel.setPatientName(jsonData.getPatient().getName());
        taskListCacheModel.setPrescno("");
        taskListCacheModel.setStartTime(nowTimeStr);
        taskListCacheModel.setCheckDataTime("");
        taskListCacheModel.setStatus(-1);//首先来是系统预判不通过
        taskListCacheModel.setSlcode(outputData.getHighestSlcode());
        taskListCacheModel.setRemainTime(-999);//提请审核的时候再给一个值

        taskAllCacheModel.setTaskListCacheModel(taskListCacheModel);

        //分库分表---这里也要放入mq去执行。
        taskManager.addTaskListModel(taskIdLong.toString(), taskListCacheModel);
        TaskListCacheModel taskModel = taskManager.getTaskModel(taskIdLong.toString());
//        redisOpsExtUtil.putHash("taskscache", taskIdLong.toString(), screenResStr);

        //4.放入rocketmq中进行存库。这里存history表、问题表等等。 分库分表

        return "";
    }

    public void applyForReview(String taskId) {
        //修改任务状态，同时通知药师来获取任务，还有一个重要的倒计时，先放入rocketmq，进行超时处理。
        //这里要保证每个任务获取状态，都定位到同一个机器上，才不会去请求redis。
        //提请审核倒计时就要开始了，怎么处理倒计时？第一，被动处理，在获取状态的时候来处理，或者获取任务的时候来处理。
        TaskListCacheModel taskModel = taskManager.getTaskModel(taskId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowTimeStr = LocalDateTime.now().format(formatter);
        if (taskModel != null){
            taskModel.setStatus(-5);
            taskModel.setStartTime(nowTimeStr);//提请审核的时间
            taskModel.setRemainTime(overTime);//这里的时间根据系统设置来。先写个1000s
            taskManager.setTaskModel(taskId,taskModel);
        }
    }

    public String getTaskStatus(String taskId) {
        TaskListCacheModel taskModel = taskManager.getTaskModel(taskId);
        //设置倒计时剩下的时间。
        if (taskModel != null && taskModel.getRemainTime() >= 0){
            long diffTime = TimeUtils.calculateSecondsDiff(taskModel.getStartTime());
            if (diffTime > overTime){
                //超时了。走超时的处理方法。
                taskModel.setRemainTime(-1);
                taskModel.setStatus(15);

                //这里又会把缓存里面的删除，那么这种模式不好哦，每次请求都要从数据库来获取。
                //所以只有超时的时候才调用
                taskManager.setTaskModel(taskId,taskModel);
            }else{
                //这里如果也走延时双删的话，就会有性能问题，因为每次来获取状态，缓存里面都会没有。。
                //更新倒计时信息，这个不能用延时双删，也不能实时操作数据库。只能操作缓存和redis
                taskModel.setRemainTime(overTime- (int) diffTime);
                localCache.put(taskId,taskModel);
            }
        }
        String s = JsonUtils.toJSONString(taskModel);
        return s;
    }
}
