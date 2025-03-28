package com.xht.passpharmreview.model.screen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: PassClientModel
 * @Description: 客户端信息
 * @Author: liuxiaoliu
 * @Date: 2023-04-18 15:24
 * @Version: V1.0
 */
@Data
public class PassClientModel implements Serializable {
    private static final long serialVersionUID = 2907600379350401811L;
    /**
     * 医院编码
     */
    @JsonProperty(value = "HospID")
    private String hospId = "";
    /**
     * 医院名称
     */
    @JsonProperty(value = "HospName")
    private String hospName = "";
    /**
     * 用户ID
     */
    @JsonProperty(value = "DoctorUqId")
    private long doctorUqId = 0;
    /**
     * 用户编码
     */
    @JsonProperty(value = "UserId")
    private String userId = "";
    /**
     * 用户名称
     */
    @JsonProperty(value = "UserName")
    private String userName = "";
    /**
     * 科室ID
     */
    @JsonProperty(value = "DeptUqId")
    private long deptUqId = 0;
    /**
     * 科室编码
     */
    @JsonProperty(value = "DeptID")
    private String deptId = "";
    /**
     * 科室名称
     */
    @JsonProperty(value = "DeptName")
    private String deptName = "";
    /**
     * 客户端的IP
     */
    @JsonProperty(value = "IP")
    private String iP = "";
    /**
     * 客户端的计算机名
     */
    @JsonProperty(value = "PCName")
    private String pcName = "";
    /**
     * 客户端的操作系统版本
     */
    @JsonProperty(value = "OSInfo")
    private String osInfo = "";
    /**
     * 客户端的分辨率
     */
    @JsonProperty(value = "Resolution")
    private String resolution = "";
    /**
     * PASS客户端的版本 0-产品暂不支持的客户端 1-PC版(默认) 2-移动版
     */
    @JsonProperty(value = "PassVersion")
    private String passVersion = "";
    /**
    * PASS客户端的信息 UserID+IP+PCName+OSInfo+ProcessID
    */
    @JsonProperty(value = "ClientInfo")
    private String clientInfo = "";
    /**
     * 产品编码
     */
    @JsonProperty(value = "ProductCode")
    private String productCode = "";
    /**
     * 是否PASS产品系列工具 1-是 0-否，用于界面（如填写用药理由）的特殊处理
     */
    @JsonProperty(value = "IsPassTool")
    private Integer isPassTool = 0;
    /**
     * 服务器电脑mac地址
     */
    @JsonProperty(value = "mac")
    private String mac = "";
    /**
     * 其它信息 备用;PA审查;2次审查存储CASEID
     */
    @JsonProperty(value = "otherinfo")
    private String otherInfo = "";
    /**
     * 审查模式
     */
    @JsonProperty(value = "CheckMode")
    private String checkMode = "";
    /**
     * 是否输出日志 0-不输出 1-输出
     */
    @JsonProperty(value = "BusinessDebug")
    private Integer businessDebug;
    /**
     * 客户端版本信息
     */
    @JsonProperty(value = "ClientVersion")
    private Integer clientVersion;
}