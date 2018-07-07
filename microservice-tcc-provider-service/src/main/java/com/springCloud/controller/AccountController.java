package com.springCloud.controller;

import com.springCloud.dao.AccountDao;
import com.springCloud.service.AccountService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Joeysin on 2017/1/31.
 */
@Compensable(interfaceClass = AccountService.class, confirmableKey = "accountServiceConfirm", cancellableKey = "accountServiceCancel")
@RestController
public class AccountController implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    @ResponseBody
    @RequestMapping(value = "/accountOne/increase", method = RequestMethod.POST)
    @Transactional
    public int increaseAmount(@RequestParam("acctId") String acctId, @RequestParam("amount") double amount) {
        int value = accountDao.increaseAmount(acctId, amount);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("exec increase: acct= %s, amount= %7.2f%n", acctId, amount);
        return value;
    }
}
