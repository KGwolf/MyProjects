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
     * @Description 审查接口
     * @Author xiahaitao
     * @Date 2025/3/24 15:25
     */
    @PostMapping("/screenViewWithPreRequest")
    public String screenViewWithPreRequest(@RequestBody String input) {
        return screenService.screenViewWithPreRequest(input);
    }


    @PostMapping(value = "/getTaskStatus", produces = {"text/html;charset=utf-8"})
    public String getTaskStatus(@RequestParam("psJSONStr") String psJsonStr) {
        return "";
//        psJsonStr = doSpecialStr(psJsonStr);
//        return getStatusService.perform(psJsonStr);
    }
}
