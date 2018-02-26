package com.springCloud.service.impl;

import com.springCloud.dao.AccountDao;
import com.springCloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceCancel")
public class AccountServiceCancel implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Transactional
    public int increaseAmount(String acctId, double amount) {
        int value = accountDao.cancel(acctId, amount);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("undo increase: acct= %s, amount= %7.2f%n", acctId, amount);
        return value;
    }
}
