package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ScreenAllergenModel
 * @Description: 过敏信息
 * @Author: liuxiaoliu
 * @Date: 2022-10-20 14:19
 * @Version: V1.0
 */
@Data
public class ScreenAllergenModel implements Serializable {
    private static final long serialVersionUID = -1367138377990093971L;
    /**
     * 内部医院编码
     */
    @JsonProperty(value = "MHisCode")
    private int mHisCode;
    /**
     * 用户过敏源序号
     */
    @JsonProperty(value = "Index")
    private String index = "";
    /**
     * 过敏源来源,USER、PASS_INNER_PASS、PA_INNER_PA
     */
    @JsonProperty(value = "AllerSource")
    private String allerSource = "USER";
    /**
     * 过敏源ID
     */
    @JsonProperty(value = "AllerUqId")
    private long allerUqId = 0;
    /**
     * 过敏源编码
     */
    @JsonProperty(value = "AllerCode")
    private String allerCode = "";
    /**
     * 用户过敏源名称
     */
    @JsonProperty(value = "AllerName")
    private String allerName = "";
    /**
     * 过敏症状
     */
    @JsonProperty(value = "AllerSymptom")
    private String allerSymptom = "";
}