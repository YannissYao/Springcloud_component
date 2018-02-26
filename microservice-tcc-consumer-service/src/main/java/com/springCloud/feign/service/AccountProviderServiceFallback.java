package com.springCloud.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Joeysin on 2018/2/13.
 */
@Component
public class AccountProviderServiceFallback implements  AccountProviderService {
    @Override
    public int increaseAmount(@RequestParam("acctId") String accountId, @RequestParam("amount") double amount) {
        System.out.println("进入 increaseAmount 断路器");
        return 0;
    }
}
