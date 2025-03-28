package com.xht.passpharmreview.model.screen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: ScreenMedCondList
 * @Description: 诊断信息链表
 * @Author: liuxiaoliu
 * @Date: 2022-11-01 15:46
 * @Version: V1.0
 */
@Data
public class ScreenMedCondList  implements Serializable {
    private static final long serialVersionUID = 6530753300854111666L;
    @JsonProperty(value = "ScreenMedConds")
    private List<ScreenMedCondModel> screenMedConds = new CopyOnWriteArrayList<>();
}