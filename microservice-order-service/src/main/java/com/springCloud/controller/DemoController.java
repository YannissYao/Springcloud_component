package com.springCloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Joeysin on 2017/1/31.
 */
@RestController
@RefreshScope
@Slf4j
public class DemoController {

    @Value("${logging.level.org.springframework.security}")
    private String param;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @HystrixCommand(fallbackMethod = "demoFallback")
    public String getDemo() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);//这个serviceId不存在所以会走demoFallback方法
    }

    @GetMapping("/balance")
    @PreAuthorize("permitAll()")
    public String getMovingParam(HttpServletRequest request) {
        System.out.println(System.currentTimeMillis());
        return request.getRemoteAddr();
    }

    @PostMapping("insert")
    @PreAuthorize("permitAll()")
    public String insert(@RequestParam("param") String param) throws InterruptedException {
        log.info(System.currentTimeMillis() + "  Insert_1");
        Thread.sleep(8000);
        return param + "_1";
    }

    public String demoFallback() {
        return "Hystrix Execute Success_1....";
    }
}
