package com.springCloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Joeysin on 2018/5/14.
 */
@Component
public class AccessFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        Object access_token = request.getParameter("access_token");
        String version = request.getHeader("version");
        String url = request.getRequestURL().toString();//localhost:8080/order/demo  固定url格式    domain/serviceId/resource
        String serviceId = url.split("/")[3];
        System.out.println("version : " + version);

        log.info("version: {} access_token: {} serviceId: {}", version, access_token, serviceId);

        //校验token
//        if (access_token == null) {
//            log.info("access_token为空，禁止访问!");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        } else {
        //TODO 根据token获取相应的登录信息，进行校验（略）

        //灰度示例 业务服务包括授权服务
        RibbonFilterContextHolder.clearCurrentContext();
        if (version != null && version.equals("1.0")) {
            RibbonFilterContextHolder.getCurrentContext().add("version", "1.0");
        } else if (version != null && version.equals("2.0")) {
            RibbonFilterContextHolder.getCurrentContext().add("version", "2.0");
        }
//        }

        //添加Basic Auth认证信息
//        ctx.addZuulRequestHeader("Authorization", "Basic " + getBase64Credentials("android", "android"));

        return null;
    }

    private String getBase64Credentials(String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }
}

