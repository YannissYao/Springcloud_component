package com.springCloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public ResponseEntity<String> getDemo() {
        restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);//这个serviceId不存在所以会走demoFallback方法
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/getMovingParam")
    public String getMovingParam() {
        return param + "_2";
    }

    @PostMapping("insert")
    @PreAuthorize("permitAll()")
    public String insert(@RequestParam("param") String param) throws InterruptedException {
        log.info(System.currentTimeMillis() + "  Insert_2");
        Thread.sleep(8000);
        return param + "_2";
    }

    public ResponseEntity<String> demoFallback() {
        return ResponseEntity.ok("RPC调用失败");
    }
}
