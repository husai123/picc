package org.java.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FileUploadApp {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadApp.class);
    }
}
