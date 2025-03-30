package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: ScreenOperationList
 * @Description: 手术信息链表
 * @Author: liuxiaoliu
 * @Date: 2022-11-01 15:48
 * @Version: V1.0
 */
@Data
public class ScreenOperationList  implements Serializable {
    private static final long serialVersionUID = -5635740465540808722L;
    @JsonProperty(value = "ScreenOperations")
    private List<ScreenOperationModel> screenOperations = new CopyOnWriteArrayList<>();
}