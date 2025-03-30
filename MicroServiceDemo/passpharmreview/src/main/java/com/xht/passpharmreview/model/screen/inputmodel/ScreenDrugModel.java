package com.xht.passpharmreview.model.screen.inputmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: ScreenDrugModel
 * @Description: 药品信息
 * @Author: liuxiaoliu
 * @Date: 2022-10-20 14:19
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDrugModel implements Serializable {
    private static final long serialVersionUID = 5841725353463457872L;
    /**
     * 处方号
     */
    @JsonProperty(value = "RecipNo")
    private String recipeNo = " ";
    /**
     * 处方药品序号
     */
    @JsonProperty(value = "Index")
    private String index;
    /**
     * 医嘱编号
     */
    @JsonProperty(value = "OrderNo")
    private Integer orderNo = 0;
    /**
     * 处方药品来源：PASS-PASS系统药品;USER-用户药品
     */
    @JsonProperty(value = "DrugSource")
    private String drugSource = "";
    /**
     * 处方药品ID
     */
    @JsonProperty(value = "DrugUqId")
    private long drugUqId;
    /**
     * 处方药品唯一码 由实施人员构造码
     */
    @JsonProperty(value = "DrugUniqueCode")
    private String drugUniqueCode;
    /**
     * 处方药品编码   医院所用药品编码
     */
    @JsonProperty(value = "DrugCode")
    private String drugCode;
    /**
     * 处方药品名称
     */
    @JsonProperty(value = "DrugName")
    private String drugName;
    /**
     * 处方药品给药单位
     */
    @JsonProperty(value = "DoseUnit")
    private String doseUnit = "";
    /**
     * 处方药品剂型
     */
    @JsonProperty(value = "Form")
    private String form = "";
    /**
     * 处方药品规格
     */
    @JsonProperty(value = "Strength")
    private String strength = "";
    /**
     * 处方药品厂家
     */
    @JsonProperty(value = "CompName")
    private String compName = "";
    /**
     * 处方药品批准文号
     */
    @JsonProperty(value = "ApprovalCode")
    private String approvalCode = "";
    /**
     * 处方给药途径类型:PASS-PASS系统给药途径;USER-用户给药途径
     */
    @JsonProperty(value = "RouteSource")
    private String routeSource = "";
    /**
     * 处方给药途径ID
     */
    @JsonProperty(value = "RouteUqId")
    private long routeUqId = 0;
    /**
     * 处方给药途径编码
     */
    @JsonProperty(value = "RouteCode")
    private String routeCode = "";
    /**
     * 处方给药途径名称
     */
    @JsonProperty(value = "RouteName")
    private String routeName = "";
    /**
     * 频次来源:PASS-PASS系统给药频次;USER-用户给药频次
     */
    @JsonProperty(value = "FreqSource")
    private String freqSource = "";
    /**
     * 频次ID
     */
    @JsonProperty(value = "FreqUqId")
    private long freqUqId = 0;
    /**
     * 用药频次
     */
    @JsonProperty(value = "Frequency")
    private String frequency = "";
    /**
     * 量/次
     */
    @JsonProperty(value = "DosePerTime")
    private String dosePerTime = "";
    /**
     * 处方用药开始时间
     */
    @JsonProperty(value = "StartTime")
    private String startTime = "";
    /**
     * 处方用药结束时间
     */
    @JsonProperty(value = "EndTime")
    private String endTime = "";
    /**
     * 处方用药执行时间
     */
    @JsonProperty(value = "ExecuteTime")
    private String executeTime = "";
    /**
     * 开嘱科室ID
     */
    @JsonProperty(value = "DeptUqId")
    private long deptUqId = 0;
    /**
     * 开嘱科室编号
     */
    @JsonProperty(value = "DeptCode")
    private String deptCode = "";
    /**
     * 开嘱科室名称
     */
    @JsonProperty(value = "DeptName")
    private String deptName = "";
    /**
     * 开嘱医生ID
     */
    @JsonProperty(value = "DoctorUqId")
    private long doctorUqId = 0;
    /**
     * 开嘱医生编号
     */
    @JsonProperty(value = "DoctorCode")
    private String doctorCode = "";
    /**
     * 开嘱医生姓名
     */
    @JsonProperty(value = "DoctorName")
    private String doctorName = "";
    /**
     * 成组标记
     */
    @JsonProperty(value = "GroupTag")
    private String groupTag = "";
    /**
     * 是否临时医嘱 0-长期医嘱 1-临时医嘱
     */
    @JsonProperty(value = "IsTempDrug")
    private Integer isTempDrug = -1;
    /**
     * 0-无特殊标记的医嘱，1-已作废，2-已停嘱，3-出院带药，9-新开医嘱
     */
    @JsonProperty(value = "OrderType")
    private Integer orderType = 0;
    /**
     * 审核/调配药师
     */
    @JsonProperty(value = "Pharmacists")
    private String pharmacists = "";
    /**
     * 核对/发药药师
     */
    @JsonProperty(value = "Pharmacists_")
    private String dispensingPharmacist = "";
    /**
     * 药品开出数量
     */
    @JsonProperty(value = "Num")
    private String num = "";
    /**
     * 药品开出数量单位
     */
    @JsonProperty(value = "NumUnit")
    private String numUnit = "";
    /**
     * 费用
     */
    @JsonProperty(value = "Cost")
    private String cost = "";
    /**
     * 用药目的(0默认,1可能预防，2可能治疗，3预防， 4治疗，5预防+治疗)
     */
    @JsonProperty(value = "Purpose")
    private Integer purpose = 0;
    /**
     * 手术编号，如果对应多手术，用，隔开，表示该药为该编号对应的手术用药
     */
    @JsonProperty(value = "OprCode")
    private String oprCode = "";
    /**
     * 用药时机 （术前、术中、术后）？（0- 未使用 1-  0.5h以内  2- 0.5-2h  3-大于2h）
     */
    @JsonProperty(value = "MediTime")
    private String mediTime = "";
    /**
     * 医嘱备注
     */
    @JsonProperty(value = "Remark")
    private String remark = "";
    /**
     * 评价单输入内容
     */
    @JsonProperty(value = "Evaluate")
    private String evaluate = "";
    /**
     * 警示级别
     */
    @JsonIgnore
    private int slcode = 0;
    /**
     * 成组状态
     */
    @JsonIgnore
    private long groupState = 0;
    /**
     * PR医嘱唯一码
     */
    @JsonIgnore
    private String orderNum = "";

    private String pharmacyCode = "";
//    public ScreenDrugModel(){
//
//    }
    /**
     * @param node 药品信息
     * @Description 拷贝构造函数
     * @Author liuxiaoliu
     * @Date 2023-05-25 21:30
     */
    public ScreenDrugModel(ScreenDrugModel node) {
        //region 拷贝构造函数
        this.recipeNo = node.recipeNo;
        this.index = node.index;
        this.orderNo = node.orderNo;
        this.drugSource = node.drugSource;
        this.drugUqId = node.drugUqId;
        this.drugUniqueCode = node.drugUniqueCode;
        this.drugCode = node.drugCode;
        this.drugName = node.drugName;
        this.doseUnit = node.doseUnit;
        this.form = node.form;
        this.strength = node.strength;
        this.compName = node.compName;
        this.approvalCode = node.approvalCode;
        this.routeSource = node.routeSource;
        this.routeUqId = node.routeUqId;
        this.routeCode = node.routeCode;
        this.routeName = node.routeName;
        this.freqSource = node.freqSource;
        this.freqUqId = node.freqUqId;
        this.frequency = node.frequency;
        this.dosePerTime = node.dosePerTime;
        this.startTime = node.startTime;
        this.endTime = node.endTime;
        this.executeTime = node.executeTime;
        this.deptUqId = node.deptUqId;
        this.deptCode = node.deptCode;
        this.deptName = node.deptName;
        this.doctorUqId = node.doctorUqId;
        this.doctorCode = node.doctorCode;
        this.doctorName = node.doctorName;
        this.groupTag = node.groupTag;
        this.isTempDrug = node.isTempDrug;
        this.orderType = node.orderType;
        this.pharmacists = node.pharmacists;
        this.dispensingPharmacist = node.dispensingPharmacist;
        this.num = node.num;
        this.numUnit = node.numUnit;
        this.cost = node.cost;
        this.purpose = node.purpose;
        this.oprCode = node.oprCode;
        this.mediTime = node.mediTime;
        this.remark = node.remark;
        this.evaluate = node.evaluate;
        this.slcode = node.slcode;
        this.groupState = node.groupState;
        this.orderNum = node.orderNum;
        this.pharmacyCode = node.pharmacyCode;
        //endregion
    }
}