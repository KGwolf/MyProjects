package com.xht.nacostest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class NacosTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosTestApplication.class, args);
	}

}
