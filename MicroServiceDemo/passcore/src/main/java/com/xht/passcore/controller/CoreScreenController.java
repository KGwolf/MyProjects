package com.xht.passcore.controller;

import com.xht.passcore.service.CoreScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: CoreScreenController
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/25 9:57
 * @Version: V1.0
 */
@RestController
@RequestMapping("/core")
public class CoreScreenController {

    @Autowired
    CoreScreenService coreScreenService;
    @PostMapping("/screen")
    public String screenWithJsonStr(@RequestBody String input) {
        return coreScreenService.screenWithJsonStr(input);
    }
}
