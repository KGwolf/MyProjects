package com.xht.distributeuqid.simpleuqid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SequenceController
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/19 13:40
 * @Version: V1.0
 */
@RestController
public class SequenceController {

    @RequestMapping(value = "/api/sequence/get")
    public String getSequenceId() {
        return IdGenerator.getIdStr();
    }

}
