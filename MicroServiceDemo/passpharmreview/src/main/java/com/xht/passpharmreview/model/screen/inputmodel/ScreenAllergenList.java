package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: ScreenAllergenList
 * @Description: 过敏信息链表
 * @Author: liuxiaoliu
 * @Date: 2022-11-01 15:47
 * @Version: V1.0
 */
@Data
public class ScreenAllergenList  implements Serializable {
    private static final long serialVersionUID = 2150379709563689613L;
    @JsonProperty(value = "ScreenAllergens")
    private List<ScreenAllergenModel> screenAllergens = new CopyOnWriteArrayList<>();
}