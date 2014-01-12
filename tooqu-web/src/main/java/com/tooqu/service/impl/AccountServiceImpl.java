/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.dao.AccountDao;
import com.tooqu.entity.User;
import com.tooqu.service.AccountService;
/**
 *
 * @author guo
 */
public class AccountServiceImpl implements AccountService{
    
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    
    @Override
    public void addUser(User u) {
        accountDao.addUser(u);
    }
    
}
