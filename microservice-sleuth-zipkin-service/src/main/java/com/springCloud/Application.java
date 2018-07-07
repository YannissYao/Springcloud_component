package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Created by Joeysin on  2018/2/26  下午4:12.
 * Describe：zipkin-UI: localhost:9411
 */
@SpringBootApplication
//@EnableZipkinServer
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
