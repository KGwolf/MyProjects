package com.xht.mygateway.config;

import com.xht.mygateway.loadbalancer.MhisCodeHashLoadBalancer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @ClassName: TargetServiceLoadBalancerConfig
 * @Description: pr微服务的自定义负载均衡配置
 * @Author: xiahaitao
 * @Date: 2025/3/31 16:05
 * @Version: V1.0
 */
@Configuration
@LoadBalancerClient(
        name = "pr",  // 目标微服务名称（需与注册中心一致）
        configuration = TargetServiceLoadBalancerConfig.class
)
public class TargetServiceLoadBalancerConfig {
    @Bean
    public ReactorServiceInstanceLoadBalancer customBalancer(
            Environment env,
            ObjectProvider<ServiceInstanceListSupplier> supplierProvider
    ) {
        String serviceId = env.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new MhisCodeHashLoadBalancer(supplierProvider, serviceId);
    }
}
