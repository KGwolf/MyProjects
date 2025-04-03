package com.xht.mygateway.loadbalancer;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: MhisCodeHashLoadBalancer
 * @Description: 根据header 中的 mhiscode 进行哈希计算，选择对应的服务实例
 * @Author: xiahaitao
 * @Date: 2025/3/31 16:02
 * @Version: V1.0
 */
public class MhisCodeHashLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    private final ObjectProvider<ServiceInstanceListSupplier> supplierProvider;
    private final String serviceId;

    public MhisCodeHashLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> supplierProvider, String serviceId) {
        this.supplierProvider = supplierProvider;
        this.serviceId = serviceId;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        // 从请求上下文中提取 mhiscode（需结合 RequestDataContext）
        RequestDataContext context = (RequestDataContext) request.getContext();
        String mhiscode = context.getClientRequest().getHeaders().getFirst("mhiscode");

        return supplierProvider.getIfAvailable()
                .get()
                .collectList()
                .flatMap(lists -> {
                    // 扁平化处理：合并所有内层 List 到单一列表
                    List<ServiceInstance> allInstances = lists.stream()
                            .flatMap(List::stream)
                            .collect(Collectors.toList());

                    if (allInstances.isEmpty()) {
                        return Mono.just(new EmptyResponse());
                    }

                    // 计算哈希索引
                    int mhiscodeInt = Integer.parseInt(mhiscode);
                    int index = mhiscodeInt % allInstances.size();

                    // 返回选中的实例
                    return Mono.just(new DefaultResponse(allInstances.get(index)));
                });
    }
}
