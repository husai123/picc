package org.java;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

//import javax.swing.*;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "org.java.customer.dao")
public class CustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class);
    }

}
