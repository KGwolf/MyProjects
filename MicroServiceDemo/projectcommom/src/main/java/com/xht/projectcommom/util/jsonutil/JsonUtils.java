package com.xht.projectcommom.util.jsonutil;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ArrayUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtils {
    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper MAPPER = new ObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return MAPPER;
    }

    public static String toJSONString(Object o) {
        return toJSONString(o, false);
    }

    public static String toJSONString(Object o, boolean format) {
        try {
            if (o == null) {
                return "";
            } else if (o instanceof Number) {
                return o.toString();
            } else if (o instanceof String) {
                return (String)o;
            } else {
                return format ? MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o) : MAPPER.writeValueAsString(o);
            }
        } catch (JsonProcessingException e) {
            log.warn("parse json string error:" + o, e);
            return null;
        }
    }

    public static <T> T toObject(String json, Class<T> cls) {
        if (!StringUtils.isBlank(json) && cls != null) {
            try {
                return (T)MAPPER.readValue(json, cls);
            } catch (IOException e) {
                log.warn("parse json string error:" + json, e);
                return null;
            }
        } else {
            return null;
        }
    }

    public static <T> T toObject(byte[] bytes, Class<T> clazz) {
        if (ArrayUtil.isEmpty(bytes)) {
            return null;
        } else {
            try {
                return (T)MAPPER.readValue(bytes, clazz);
            } catch (IOException e) {
                log.warn("parse byte string error:", e);
                return null;
            }
        }
    }

    public static <T> T toObject(String json, Class<?> parametrized, Class<?>... parameterClasses) {
        if (!StringUtils.isBlank(json) && parametrized != null) {
            try {
                JavaType javaType = MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
                return (T)MAPPER.readValue(json, javaType);
            } catch (IOException e) {
                log.warn("parse byte string error:" + json, e);
                return null;
            }
        } else {
            return null;
        }
    }

    public static <T> T toObject(String json, TypeReference<T> typeReference) {
        if (!StringUtils.isBlank(json) && typeReference != null) {
            try {
                return (T)MAPPER.readValue(json, typeReference);
            } catch (IOException e) {
                log.warn("parse byte string error:" + json, e);
                return null;
            }
        } else {
            return null;
        }
    }

    public static JsonNode parse(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return MAPPER.readTree(json);
            } catch (IOException e) {
                log.warn("parse byte string error:" + json, e);
                return null;
            }
        }
    }

    public static <K, V> Map<K, V> toMap(Object o) {
        if (o == null) {
            return null;
        } else {
            return o instanceof String ? (Map)toObject((String)o, Map.class) : (Map)MAPPER.convertValue(o, Map.class);
        }
    }

    public static <T> List<T> toList(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return (List)MAPPER.readValue(json, List.class);
            } catch (JsonProcessingException e) {
                log.warn("parse String to List error:" + json, e);
                return null;
            }
        }
    }

    public static <T> List<T> toList(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{cls});
                return (List)MAPPER.readValue(json, javaType);
            } catch (JsonProcessingException e) {
                log.warn("parse String to List error:" + json, e);
                return null;
            }
        }
    }

    public static Dict parseMap(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        } else {
            try {
                return (Dict)MAPPER.readValue(text, MAPPER.getTypeFactory().constructType(Dict.class));
            } catch (MismatchedInputException var2) {
                return null;
            } catch (IOException e) {
                return null;
            }
        }
    }

    private JsonUtils() {
    }

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.configure(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature(), true);
        MAPPER.configure(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(), true);
        MAPPER.configure(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature(), true);
        MAPPER.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        MAPPER.enable(new MapperFeature[]{MapperFeature.USE_STD_BEAN_NAMING});
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }
}

