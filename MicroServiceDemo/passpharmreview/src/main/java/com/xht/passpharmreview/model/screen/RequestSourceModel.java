package com.xht.passpharmreview.model.screen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: RequestSourceModel
 * @Description: 互联网审方前缀
 * @Author: liuxiaoliu
 * @Date: 2022-10-20 14:19
 * @Version: V1.0
 */
@Data
public class RequestSourceModel implements Serializable {
    private static final long serialVersionUID = -102392065604765281L;
    /**
     * 类型
     */
    @JsonProperty(value = "type")
    private String type ;
    /**
     * 时间
     */
    @JsonProperty(value = "date")
    private String date;
    /**
     * 客户端IP
     */
    @JsonProperty(value = "clientIP")
    private String clientIp ;
}