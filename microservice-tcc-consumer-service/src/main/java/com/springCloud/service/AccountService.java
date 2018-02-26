package com.springCloud.service;

import org.apache.ibatis.annotations.Param;

public interface AccountService {

    int increaseAmount(@Param("acctId") String acctId, @Param("amount") double amount);

}
