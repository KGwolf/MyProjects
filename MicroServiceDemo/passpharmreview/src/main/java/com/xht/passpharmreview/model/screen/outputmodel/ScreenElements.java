package com.xht.passpharmreview.model.screen.outputmodel;

import lombok.Data;

import java.util.List;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  11:04
 * @Description: TODO
 * @Version: 1.0
 **/
@Data
public class ScreenElements {
    private List<String> OrderIndexs;
    private String PassRule;
    private List<Object> OtherRecipeNos;
    private String TaskDrugIndex;
    private String Pharmcy;
    private Integer PharmacyInfo;
}
