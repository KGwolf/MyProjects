package com.xht.passpharmreview.model.screen.outputmodel;

import lombok.Data;

import java.util.List;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  11:02
 * @Description: TODO
 * @Version: 1.0
 **/
@Data
public class ScreenResultOutput {
    private Integer HighestSlcode;
    private Integer PrSlCode;
    private Integer IsClientFilterDupWarn;
    private String BusinessDebugData;
    private String InUseModules;
    private String Delimiter;
    private Integer MustUseReason;
    private Integer IsNewWarning;
    private Integer ShouldBlock;
    private Integer Refuse;
    private Integer ShowToDoctor;
    private Integer ShowToPharm;
    private Integer SilenceScreen;
    private Integer ShowWarningType;
    private Integer IsReasonShowOtherItem;
    private List<ScreenResultDrug> ScreenResultDrugs;
    private List<Object> ScreenResultPatients;
    private List<Object> ScreenResultRecipes;
    private PatientStatusInfo PatientStatusInfo;
    private TrafficControlInfo TrafficControlInfo;
}
