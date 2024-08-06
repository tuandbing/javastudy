package com.eagles.mapper;

import com.eagles.pojo.Account;

import java.util.List;

public interface AccountMapper {


    List<Account> findAccounts();

    Account findAccountByUid(Integer uid);

}
