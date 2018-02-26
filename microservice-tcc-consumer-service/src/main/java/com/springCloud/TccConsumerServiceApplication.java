package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
@EnableFeignClients
public class TccConsumerServiceApplication {



    public static void main(String[] args) {
        SpringApplication.run(TccConsumerServiceApplication.class, args);
    }
}
