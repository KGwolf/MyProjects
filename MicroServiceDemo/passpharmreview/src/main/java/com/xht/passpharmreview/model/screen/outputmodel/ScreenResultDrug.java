package com.xht.passpharmreview.model.screen.outputmodel;

import lombok.Data;

import java.util.List;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  11:03
 * @Description: TODO
 * @Version: 1.0
 **/
@Data
public class ScreenResultDrug {
    private Integer drugHighSlcode;
    private Integer drugPassHighSlcode;
    private Integer drugPrHighSlcode;
    private Long hashId;
    private String DrugIndex;
    private String DrugName;
    private Integer SlCode;
    private Integer PassCoreSlCode;
    private Integer PrSlCode;
    private String MenuLabel;
    private String DrugUniqueHash;
    private Integer WarnType;
    private String SubWarnType;
    private Integer IsNewWarning;
    private String DrugUniqueCode;
    private String DrugSource;
    private String RouteCode;
    private String RouteName;
    private String RecomUsage;
    private String RecomReason;
    private String ImportantLabItems;
    private String DetailReason;
    private String DeptCode;
    private String DeptName;
    private String DoctorCode;
    private String DoctorName;
    private Integer ShouldBlock;
    private Integer Refuse;
    private Integer ShowToDoctor;
    private Integer ShowToPharm;
    private Integer HasPassReason;
    private Integer SilenceScreen;
    private Integer IsDischargeDrugResult;
    private Integer IsObtainOrder;
    private String ReasonGroupIds;
    private Integer MustUseReason;
    private Boolean IsExecTempDrug;
    private Integer SpecialFlags;
    private List<ScreenResult> ScreenResults;
}
