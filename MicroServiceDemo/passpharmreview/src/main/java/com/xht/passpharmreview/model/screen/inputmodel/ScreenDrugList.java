package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: ScreenDrugList
 * @Description: 药品信息链表
 * @Author: liuxiaoliu
 * @Date: 2022-11-01 15:48
 * @Version: V1.0
 */
@Data
public class ScreenDrugList implements Serializable {
    private static final long serialVersionUID = -8393393547419350016L;
    @JsonProperty(value = "ScreenDrugs")
    private List<ScreenDrugModel> screenDrugs = new CopyOnWriteArrayList<>();
}