package com.xht.passpharmreview.model.initload;

import lombok.Data;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: PharmacistModel
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/5/28 20:19
 * @Version: V1.0
 */
@Data
public class PharmacistModel {
    /**
     * 用户编码 - 键
     */
    private int userId;

    /**
     * 所属区域医疗机构名称
     */
    private String hospName = "";

    /**
     * 医院编码（美康内部）
     */
    private int mHisCode;

    /**
     * 用户登录名
     */
    private String loginName = "";

    /**
     * 用户名称
     */
    private String userName = "";

    /**
     * 药师联系电话-手机
     */
    private String mobile = "";

    /**
     * 药师联系电话-座机
     */
    private String telephone = "";

    /**
     * 数据权限-医院
     */
    private Map<String, Collection<Integer>> dataRights = new ConcurrentHashMap<>();
}
