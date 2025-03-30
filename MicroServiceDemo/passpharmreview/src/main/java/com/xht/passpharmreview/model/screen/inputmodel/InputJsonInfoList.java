package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Data
public class InputJsonInfoList  implements Serializable {
    private static final long serialVersionUID = -2050436728271018160L;
    @JsonProperty(value = "InputJsonInfos")
    private List<Object> inputJsonInfos = new CopyOnWriteArrayList<>();
}