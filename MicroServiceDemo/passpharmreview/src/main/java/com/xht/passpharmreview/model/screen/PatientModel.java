package com.xht.passpharmreview.model.screen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: PatientModel
 * @Description: 病人信息
 * @Author: liuxiaoliu
 * @Date: 2022-10-20 14:19
 * @Version: V1.0
 */
@Data
public class PatientModel implements Serializable {
    private static final long serialVersionUID = -147896659679870797L;
    /**
     * 病人唯一码(跨院就诊相同） 默认 “”
     */
    @JsonProperty(value = "arcbasid")
    private String arcBasId = "";

    /**
     * 患者授权标记 0-未授权（默认） 1-授权
     */
    @JsonProperty(value = "empower")
    private int empower = 0;
    /**
     * 关联病人唯一码（跨院区保证能找到唯一的病人）
     */
    @JsonProperty(value = "CorrelationPatCode")
    private String correlationPatCode = "";
    /**
     * 病人编码
     */
    @JsonProperty(value = "PatCode")
    private String patCode = "";
    /**
     * 门诊号/住院号
     */
    @JsonProperty(value = "InHospNo")
    private String inHospNo = "";
    /**
     * 门诊号/住院次数
     */
    @JsonProperty(value = "VisitCode")
    private String visitCode = "";
    /**
     * 姓名
     */
    @JsonProperty(value = "Name")
    private String name = "";
    /**
     * 性别
     */
    @JsonProperty(value = "Sex")
    private String sex = "";
    /**
     * 出生日期
     */
    @JsonProperty(value = "Birthday")
    private String birthday = "";
    /**
     * 身高（cm）
     */
    @JsonProperty(value = "HeightCM")
    private String heightCm = "";
    /**
     * 体重（kg）
     */
    @JsonProperty(value = "WeighKG")
    private String weighKg = "";
    /**
     * 科室ID
     */
    @JsonProperty(value = "DeptUqId")
    private long deptUqId = 0;
    /**
     * 科室编码
     */
    @JsonProperty(value = "DeptCode")
    private String deptCode = "";
    /**
     * 科室
     */
    @JsonProperty(value = "DeptName")
    private String deptName = "";
    /**
     * 医生ID
     */
    @JsonProperty(value = "DoctorUqId")
    private long doctorUqId = 0;
    /**
     * 主管医生编码
     */
    @JsonProperty(value = "DoctorCode")
    private String doctorCode = "";
    /**
     * 主管医生姓名
     */
    @JsonProperty(value = "DoctorName")
    private String doctorName = "";
    /**
     * 病人状态 0-出院，1-住院（默认），2-门诊，3-急诊 ，4-互联网
     */
    @JsonProperty(value = "PatStatus")
    private int patStatus = 1;
    /**
     * 是否哺乳 -1-无法获取哺乳状态（默认） 0-不是 1-是
     */
    @JsonProperty(value = "IsLactation")
    private int isLactation = -1;
    /**
     * 是否妊娠 -1-无法获取妊娠状态（默认） 0-不是 1-是 2
     */
    @JsonProperty(value = "IsPregnancy")
    private int isPregnancy = -1;
    /**
     * 妊娠开始日期，不为空，则计算妊娠期，否则出全期数据
     */
    @JsonProperty(value = "PregStartDate")
    private String pregStartDate = "";
    /**
     * -1-无法获取肝损害状态（默认）;0-无肝损害,1-存在肝损害,但损害程度不明确,2-轻度肝损害,3-中度肝损害,4-重度肝损害
     */
    @JsonProperty(value = "HepDamageDegree")
    private Integer hepDamageDegree = -1;
    /**
     * -1-无法获取肾损害状态（默认）;0-无肾损害,1-存在肾损害，但损害程度不明确,2-轻度肾损害,3-中度肾损害,4-重度肾损害
     */
    @JsonProperty(value = "RenDamageDegree")
    private int renDamageDegree = -1;
    /**
     * 审查时间
     */
    @JsonProperty(value = "UseTime")
    private String useTime = "";
    /**
     * 审查模式
     */
    @JsonProperty(value = "CheckMode")
    private String checkMode = "";
    /**
     * 是否执行采集 1-采集 0-不采集 由客户端传入
     */
    @JsonProperty(value = "IsDoSave")
    private int isDoSave = 1;
    /**
     * 年龄
     */
    @JsonProperty(value = "Age")
    private String age = "";
    /**
     * 费别
     */
    @JsonProperty(value = "PayClass")
    private String payClass = "";
    /**
     * 是否做过病原学检查  0-未做过（默认） 1-做过
     */
    @JsonProperty(value = "IsTestEtiology")
    private int isTestEtiology = 0;
    /**
     * 门（急）诊为就诊时间，住（出院）为入院时间
     */
    @JsonProperty(value = "InHospDate")
    private String inHospDate = "";
    /**
     * 门（急）诊为就诊时间，住（出院）为出院院时间
     */
    @JsonProperty(value = "OutHospDate")
    private String outHospDate = "";
    /**
     * 病人身份证号
     */
    @JsonProperty(value = "IDCard")
    private String idCard = "";
    /**
     * 联系电话
     */
    @JsonProperty(value = "Telephone")
    private String telephone = "";
    /**
     * 估算出生日期
     */
    @JsonProperty(value = "BirthdayDesc")
    private String birthdayDesc = "";
    /**
     * 估算身高
     */
    @JsonProperty(value = "HeightCMDesc")
    private String heightCmDesc = "";
    /**
     * 身高来源
     */
    @JsonProperty(value = "HeightSource")
    private String heightSource = "HIS";
    /**
     * 估算体重
     */
    @JsonProperty(value = "WeightKGDesc")
    private String weightKgDesc = "";
    /**
     * 体重来源
     */
    @JsonProperty(value = "WeightSource")
    private String weightSource = "HIS";
    /**
     * 体表面积
     */
    @JsonProperty(value = "BodyArea")
    private String bodyArea = "";
    /**
     * 体表面积(传给PASS审查用，只有数字，没有文字)
     */
    @JsonProperty(value = "BodyAreaCalc")
    private String bodyAreaCalc = "";
    /**
     * 病区ID
     */
    @JsonProperty(value = "WardUqId")
    private long wardUqId = 0;
    /**
     * 病区编码
     */
    @JsonProperty(value = "WardCode")
    private String wardCode = "";
    /**
     * 病区名称
     */
    @JsonProperty(value = "WardDesc")
    private String wardDesc ="";
    /**
     * 抗菌药使用评估单
     */
    @JsonProperty(value = "AntiEvaluate")
    private String antiEvaluate ="";
    /**
     * 医保标记
     */
    @JsonProperty(value = "MedicareType")
    private String medicareType = "";
    /**
     * 是否禁食 0-否（默认） 1-是
     */
    @JsonProperty(value = "IsFast")
    private int isFast = 0;
    /**
     * 体温
     */
    @JsonProperty(value = "Temperature")
    private double temperature = 36.5;
    /**
     * 病人身份
     */
    @JsonProperty(value = "PatLevel")
    private String patLevel = "";

    //region 个性化相关字段

    /**
     * 特殊病人超多日用量审批标记（四川省人民医院）： 0：未经HIS审批或审批不通过，需要PASS按正常病人审查（默认），1：HIS系统审批通过，病人的所有药品按90天审查
     */
    @JsonProperty(value = "Multidaydosepriv")
    private int multiDayDosePriv = 0;

    /**
     * 重庆儿童XML格式签名信息使用的流水号
     */
    @JsonProperty(value = "InterPrescno")
    private String interPrescNo = "";

    //region 河南省人民医院用药指导单使用
    /**
     * 床位
     */
    @JsonProperty(value = "BedNo")
    private String bedNo = null;
    /**
     * 病案号
     */
    @JsonProperty(value = "DoucmentNo")
    private String documentNo = null;
     //endregion

    //endregion
}