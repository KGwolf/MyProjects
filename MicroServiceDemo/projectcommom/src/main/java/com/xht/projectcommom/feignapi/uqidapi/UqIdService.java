package com.xht.projectcommom.feignapi.uqidapi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: GetUqId
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/21 17:00
 * @Version: V1.0
 */
@FeignClient(name = "uqid")
public interface UqIdService {
    @GetMapping("/api/segment/get/{key}")
    String getSegmentId(@PathVariable("key") String key);

    @GetMapping("/api/sequence/get")
    String getSequenceId();
}
