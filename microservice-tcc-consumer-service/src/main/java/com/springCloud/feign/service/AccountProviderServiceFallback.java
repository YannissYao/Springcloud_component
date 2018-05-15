package com.springCloud.feign.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Joeysin on 2018/2/13.
 */
@Component
@Slf4j
public class AccountProviderServiceFallback implements AccountProviderService {
    @Override
    public int increaseAmount(@RequestParam("acctId") String accountId, @RequestParam("amount") double amount) {
        log.info("进入 increaseAmount 断路器");
        return 0;
    }
}
