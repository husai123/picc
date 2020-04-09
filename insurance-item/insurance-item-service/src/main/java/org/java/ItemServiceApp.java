package org.java;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "org.java.insurance.mapper")  //扫描mapper
public class ItemServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApp.class);
    }
}
