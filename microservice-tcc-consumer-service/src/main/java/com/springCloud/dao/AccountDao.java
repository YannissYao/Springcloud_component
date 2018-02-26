package com.springCloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Joeysin on 2018/2/13.
 */
@Mapper
public interface AccountDao {
    int increaseAmount(@Param("acctId") String acctId, @Param("amount") double amount);

    int confirm(@Param("acctId") String acctId, @Param("amount") double amount);

    int cancel(@Param("acctId") String acctId, @Param("amount") double amount);
}
