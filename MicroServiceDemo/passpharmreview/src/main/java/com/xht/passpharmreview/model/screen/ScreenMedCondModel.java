package com.xht.passpharmreview.model.screen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ScreenMedCondModel
 * @Description: 处方疾病名称信息
 * @Author: liuxiaoliu
 * @Date: 2022-10-20 14:19
 * @Version: V1.0
 */
@Data
public class ScreenMedCondModel implements Serializable {
    private static final long serialVersionUID = 2949780230136281390L;
    /**
     * 处方号
     */
    @JsonProperty(value = "RecipNo")
    private String recipeNo = "";
    /**
     * 处方疾病名称序号
     */
    @JsonProperty(value = "Index")
    private String index = "";
    /**
     * 处方中疾病名称来源;PASS-PASS系统ICD,USER- 用户疾病名称
     */
    @JsonProperty(value = "DisSource")
    private String disSource = "";
    /**
     * 处方疾病ID
     */
    @JsonProperty(value = "DisUqId")
    private long disUqId = 0;
    /**
     * 处方疾病名称编码
     */
    @JsonProperty(value = "DiseaseCode")
    private String diseaseCode = "";
    /**
     * 处方中疾病名称描述
     */
    @JsonProperty(value = "DiseaseName")
    private String diseaseName = "";
    /**
     * 0-出院诊断（默认） 1-入院诊断 当为门诊病人时，不计算该标记
     */
    @JsonProperty(value = "DisTimeType")
    private Integer disTimeType = 0;
    /**
     * 是否院类继发感染  1-是 0-不是
     */
    @JsonProperty(value = "Ishospinfection")
    private Integer isHospInfection = 0;
    /**
     * 诊断开始时间
     */
    @JsonProperty(value = "StartTime")
    private String startTime = "";
    /**
     *  诊断结束时间
     */
    @JsonProperty(value = "EndTime")
    private String endTime = "";
    /**
     *  是否主诊断
     */
    @JsonIgnore
    private int isMain = 0;
    /**
     *  顺序号
     */
    @JsonIgnore
    private int sortId  = 0;
}