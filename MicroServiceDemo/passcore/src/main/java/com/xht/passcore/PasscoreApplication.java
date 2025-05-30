package com.xht.passcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.xht.projectcommom")
public class PasscoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasscoreApplication.class, args);
    }

}
