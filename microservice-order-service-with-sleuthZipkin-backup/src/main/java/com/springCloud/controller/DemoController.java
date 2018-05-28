package com.springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Joeysin on 2017/1/31.
 */
@RestController
public class DemoController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/zipkin/test")
    public int getMovingParam() {
        int result=restTemplate.getForObject("http://microservice-order-service-with-sleuthZipkin-backup/zipkin/test",Integer.class);
        return result;
    }

}
