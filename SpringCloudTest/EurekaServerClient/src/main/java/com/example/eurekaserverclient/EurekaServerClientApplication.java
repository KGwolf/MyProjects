package com.example.eurekaserverclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerClientApplication.class, args);
    }

}
