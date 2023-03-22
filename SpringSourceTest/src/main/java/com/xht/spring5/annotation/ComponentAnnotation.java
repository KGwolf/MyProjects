package com.xht.spring5.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:app.properties",encoding = "utf-8")
public class ComponentAnnotation {
    @Value("${name}")
    public String name;
}
