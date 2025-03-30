package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ScreenOperationModel
 * @Description: 手术信息
 * @Author: liuxiaoliu
 * @Date: 2022-10-20 14:19
 * @Version: V1.0
 */
@Data
public class ScreenOperationModel implements Serializable {
    private static final long serialVersionUID = -7893232429264126012L;
    /**
     * 手术序号
     */
    @JsonProperty(value = "Index")
    private String index;
    /**
     * 手术ID
     */
    @JsonProperty(value = "OprUqId")
    private long oprUqId;
    /**
     * 手术编码
     */
    @JsonProperty(value = "OprCode")
    private String oprCode;
    /**
     * 手术名称
     */
    @JsonProperty(value = "OprName")
    private String oprName;
    /**
     * 切口类型(保留）
     */
    @JsonProperty(value = "IncisionType")
    private String incisionType;
    /**
     * 手术开始时间（YYYY-MM-DD HH:MM:SS)
     */
    @JsonProperty(value = "OprStartDate")
    private String oprStartDate;
    /**
     * 手术结束时间 （YYYY-MM-DD HH:MM:SS)
     */
    @JsonProperty(value = "OprEndDate")
    private String oprEndDate;
    /**
     * 手术用药时机     0- 未使用 1-  0.5h以内  2- 0.5-2h  3-大于2h
     */
    @JsonProperty(value = "OprMediTime")
    private Integer oprMediTime = -1;
    /**
     * 手术预防使用抗菌药物疗程  单位（小时）
     */
    @JsonProperty(value = "OprTreatTime")
    private Integer oprTreatTime = -1;
}