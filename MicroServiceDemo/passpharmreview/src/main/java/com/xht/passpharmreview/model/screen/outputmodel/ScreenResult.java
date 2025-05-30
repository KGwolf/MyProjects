package com.xht.passpharmreview.model.screen.outputmodel;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  11:03
 * @Description: TODO
 * @Version: 1.0
 **/

import lombok.Data;

import java.util.Map;

@Data
public class ScreenResult {
    private Long hashId;
    private Integer ModuleID;
    private String ModuleName;
    private Integer SubModuleID;
    private String SubModuleName;
    private String ModuleItems;
    private Integer SlCode;
    private Integer PassCoreSlCode;
    private Integer PrSlCode;
    private String Severity;
    private String Warning;
    private String OtherWarning;
    private Integer ForStatic;
    private String OtherInfo;
    private Integer DetailType;
    private String DetailParams;
    private String Abstract;
    private String TipAttach;
    private String LinkText;
    private String LinkParams;
    private String DetailReason;
    private String DelDupWarning;
    private Integer IsNewWarning;
    private String WarningHash;
    private Integer ShouldBlock;
    private Integer Refuse;
    private Integer ShowToDoctor;
    private Integer ShowToPharm;
    private Integer DoctorFilter;
    private Integer RuleID;
    private Integer SilenceScreen;
    private String RecipNo;
    private ScreenElements ScreenElements;
    private Map<String, Long> DrugWarningHashs;
    private Integer Monitor;
    private Integer AutoMonitor;
    private Integer PharmMonitor;
    private Integer ReasonGroupId;
    private Integer recovery;
    private Integer FilterState;
    private Integer IsNewQuestion;
    private Integer IsFocus;
    private Integer HasPassReason;
    private Integer MustUseReason;
    private String Reason;
    private String WarningConsistEvalhash;
    private String WarningConsistEval;
    private String WarningHashFilter;
    private Integer UseReason;
    private String CustomWarning;
    private String HistoryRecipeInfo;
    private Integer LocalResult;
    private String OtherHistoryRecipeInfo;
}
