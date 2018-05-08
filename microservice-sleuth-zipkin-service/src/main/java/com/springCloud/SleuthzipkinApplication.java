package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


/**
 * Created by Joeysin on  2018/2/26  下午4:12.
 * Describe：zipkin-UI: localhost:9411
 */
@SpringBootApplication
@EnableZipkinStreamServer
@EnableEurekaClient
public class SleuthzipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthzipkinApplication.class, args);
    }
}
