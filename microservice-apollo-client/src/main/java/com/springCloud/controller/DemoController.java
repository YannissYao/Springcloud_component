package com.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RefreshScope
public class DemoController {

    @Value("${a}")
    private String refreshScope;

    @GetMapping("demo")
    public String demo() throws InterruptedException {
        return refreshScope;
    }
}
