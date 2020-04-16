package org.java.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "org.java.insurance.dao")
public class BackstageApp {
    public static void main(String[] args) {
        SpringApplication.run(BackstageApp.class);
    }
}
