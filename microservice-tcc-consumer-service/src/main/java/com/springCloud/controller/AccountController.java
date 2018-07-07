package com.springCloud.controller;

import com.springCloud.dao.AccountDao;
import com.springCloud.feign.service.AccountProviderService;
import com.springCloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.bytesoft.compensable.Compensable;
import org.bytesoft.compensable.CompensableCancel;
import org.bytesoft.compensable.CompensableConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joeysin on 2017/1/31.
 */
@Compensable(interfaceClass = AccountService.class, simplified = true)
@RestController
@Slf4j
public class AccountController implements AccountService {


    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountProviderService accountProviderService;


    @ResponseBody
    @RequestMapping(value = "/accountTwo/increase", method = RequestMethod.POST)
    @Transactional
    @Override
    public int increaseAmount(@Param("acctId") String acctId, @Param("amount") double amount) {

        int result = accountProviderService.increaseAmount(acctId, amount);//rpc -1

        log.info("DO Remoting  Rpc  " + (result > 0 ? "SUCCESS" : "FAILURE"));

        result = accountDao.increaseAmount(acctId, amount); //local +1

        log.info("DO Local Ipc  " + (result > 0 ? "SUCCESS" : "FAILURE"));

//        throw new RuntimeException("rollback!");
        return result;
    }

    @CompensableConfirm
    @Transactional
    public void confirm(String acctId, double amount) {
        int value = accountDao.confirm(acctId, amount);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("done increase: acct= %s, amount= %7.2f%n", acctId, amount);
    }

    @CompensableCancel
    @Transactional
    public void cancel(String acctId, double amount) {
        int value = accountDao.cancel(acctId, amount);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", acctId, amount);
    }
}
