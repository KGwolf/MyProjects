package com.xht.projectcommom.feignapi.coreapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: CoreScreenService
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/25 10:01
 * @Version: V1.0
 */
@FeignClient(name = "core")
public interface CoreScreenService {

    @PostMapping("/core/screen")
    String screenWithJsonStr(@RequestBody String input);

}
