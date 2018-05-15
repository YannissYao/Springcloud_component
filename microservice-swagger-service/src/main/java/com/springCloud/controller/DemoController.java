package com.springCloud.controller;

import com.springCloud.domain.Domain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
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
    @ApiOperation(value = "value", tags = "POST测试接口")
    public String getDemo(@RequestBody Domain domain) {
        System.out.println(domain.toString());
        return "http://SERVICE-HELLOWORLD/";
    }

    /**
     * Created by Joeysin on  2018/5/15  上午11:52.
     * Describe：paramType
     path	以地址的形式提交数据
     query	直接跟参数完成自动映射赋值
     body	以流的形式提交 仅支持POST
     header	参数在request headers 里边提交
     */
    @ApiOperation(value = "/demo2", tags = "GET测试接口")
    @ApiImplicitParam(paramType = "query", name = "param", value = "信息参数", required = true)
    @GetMapping("/demo2")
    public String getDemo2() {
        return "http://SERVICE-HELLOWORLD/";
    }
}
