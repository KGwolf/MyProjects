package com.xht.passpharmreview.service;

import com.xht.passpharmreview.cachemanager.task.TaskManager;
import com.xht.passpharmreview.model.screen.JsonDataModel;
import com.xht.passpharmreview.model.screen.cachemodel.TaskCacheModel;
import com.xht.projectcommom.feignapi.coreapi.CoreScreenService;
import com.xht.projectcommom.feignapi.uqidapi.UqIdService;
import com.xht.projectcommom.util.jsonutil.JsonUtils;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private static final String HOSP_ID_REG = "\"HospID\":\"(\\w+)\"";

    @Autowired
    CoreScreenService coreScreenService;

    @Autowired
    RedisOpsExtUtil redisOpsExtUtil;

    @Autowired
    UqIdService uqIdService;
    @Autowired
    TaskManager taskManager;
    private static final Map<String, Integer> map = new HashMap<>();

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

        TaskCacheModel taskCacheModel = new TaskCacheModel();
        taskCacheModel.setTaskId(taskIdLong);

        taskManager.setTaskModel(taskIdLong.toString(), taskCacheModel);

        TaskCacheModel taskModel = taskManager.getTaskModel(taskIdLong.toString());
        //redisOpsExtUtil.putHash("taskscache", taskIdLong.toString(), screenResStr);

        //4.放入rocketmq中进行存库。

        return "";
    }
}
