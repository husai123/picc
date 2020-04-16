package org.java;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan(basePackages = "org.java.order.dao")
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class);
    }
}
