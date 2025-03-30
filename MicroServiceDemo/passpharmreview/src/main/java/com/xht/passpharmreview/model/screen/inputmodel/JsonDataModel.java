package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName: JsonDataModel
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/25 15:15
 * @Version: V1.0
 */
@Data
public class JsonDataModel {
    /**
     * 来源信息
     */
    @JsonProperty(value = "RequestSource")
    private RequestSourceModel requestSource;

    /**
     * 客户端信息
     */
    @JsonProperty(value = "PassClient")
    private PassClientModel passClient;

    /**
     * 病人信息
     */
    @JsonProperty(value = "Patient")
    private PatientModel patient;

    /**
     * 过敏信息
     */
    @JsonProperty(value = "ScreenAllergenList")
    private ScreenAllergenList screenAllergenList;

    /**
     * 诊断信息
     */
    @JsonProperty(value = "ScreenMedCondList")
    private ScreenMedCondList screenMedcondList;

    /**
     * 手术信息
     */
    @JsonProperty(value = "ScreenOperationList")
    private ScreenOperationList screenOperationList;

    /**
     * 药品信息
     */
    @JsonProperty(value = "ScreenDrugList")
    private ScreenDrugList screenDrugList;

    /**
     * 补充信息
     */
    @JsonProperty(value = "InputJsonInfoList")
    private InputJsonInfoList inputJsonInfoList;
}
