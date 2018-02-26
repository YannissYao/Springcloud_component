package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDiscoveryClient
@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
public class TccProviderServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(TccProviderServiceApplication.class, args);
    }
}
