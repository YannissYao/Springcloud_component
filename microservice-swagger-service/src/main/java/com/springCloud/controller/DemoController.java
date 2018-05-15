package com.springCloud.controller;

import com.springCloud.domain.Domain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joeysin on 2017/1/31.
 */
@RestController
@RefreshScope
@Api(consumes = "application/json",
        produces = "application/json",
        protocols = "http",
        basePath = "", value = "XXXXXXXXX 服务")
public class DemoController {


    @PostMapping("/demo")
    @ApiOperation(value = "value", tags = "测试接口")
    public String getDemo(@RequestBody Domain domain) {
        System.out.println(domain.toString());
        return "http://SERVICE-HELLOWORLD/";
    }


}
