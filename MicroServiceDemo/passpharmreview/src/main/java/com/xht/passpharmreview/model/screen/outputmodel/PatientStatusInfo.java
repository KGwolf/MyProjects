package com.xht.passpharmreview.model.screen.outputmodel;

import lombok.Data;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  11:04
 * @Description: TODO
 * @Version: 1.0
 **/
@Data
public class PatientStatusInfo {
    private Integer PregStatus;
    private Integer CalcPregDays;
    private Integer LactationStatus;
    private Integer HepDamageDegree;
    private Integer RenDamageDegree;
    private String PregnancyCalSrc;
    private String LactationCalSrc;
    private String HepDamageCalSrc;
    private String RenDamageCalSrc;
    private Integer DialysisStatus;
    private Object Temperature;
}
