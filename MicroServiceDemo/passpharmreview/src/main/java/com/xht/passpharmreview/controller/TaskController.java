package com.xht.passpharmreview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  21:18
 * @Description: 药师前端轮询是否有新任务？websocket获取？
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/task")
public class TaskController {
    @PostMapping(value = "/getNewTask", produces = {"text/html;charset=utf-8"})
    public String getNewTask(@RequestParam("userId") String userId) {
        //从redis缓存中去拿？ 还是推送过来？
        //redis维护一个队列？ 新任务列表？
        //还是用推送的比较好，药师这边可以用websocket，但是可以说这是优化后的结果，优化前也是轮询，
        return "";
//        psJsonStr = doSpecialStr(psJsonStr);
//        return getStatusService.perform(psJsonStr);
    }
}
