package com.xht.passpharmreview.controller;

import com.xht.passpharmreview.service.ScreenService;
import com.xht.projectcommom.feignapi.uqidapi.UqIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PrController
 * @Description: 审方，分库分表+redis+rocketmq
 * @Author: xiahaitao
 * @Date: 2025/3/21 22:45
 * @Version: V1.0
 */
@RestController
@RequestMapping("/pr")
public class PrController {
    @Autowired
    UqIdService uqIdService;

    @Autowired
    ScreenService screenService;

    /***
     * @param
     * @return java.lang.String
     * @Description 获取订单号TaskId
     * @Author xiahaitao
     * @Date 2025/3/24 15:02
     */
    @GetMapping("/api/uqid/get")
    public String getUqId() {
        return uqIdService.getSegmentId("order_id");
    }

    /***
     * @param input
     * @return java.lang.String
     * @Description 审查接口  sentinal限流。
     * @Author xiahaitao
     * @Date 2025/3/24 15:25
     */
    @PostMapping("/screenViewWithPreRequest")
    public String screenViewWithPreRequest(@RequestBody String input) {
        return screenService.screenViewWithPreRequest(input);
    }


    @PostMapping(value = "/getTaskStatus", produces = {"text/html;charset=utf-8"})
    public String getTaskStatus(@RequestParam("taskId") String taskId) {
        String taskStatus = screenService.getTaskStatus(taskId);
        return taskStatus;

    }

    @PostMapping(value = "/applyForReview", produces = {"text/html;charset=utf-8"})
    public String applyForReview(@RequestParam("taskId") String taskId) {
        //修改任务状态，同时通知药师来获取任务，还有一个重要的倒计时，先放入rocketmq，进行超时处理。
        //这里要保证每个任务获取状态，都定位到同一个机器上，才不会去请求redis。
        screenService.applyForReview(taskId);
        return "1";

    }
}
