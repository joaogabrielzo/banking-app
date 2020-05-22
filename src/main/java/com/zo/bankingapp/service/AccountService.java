package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.Account;

public interface AccountService {

    public void createAccount(String user);

    public Float getBalanceFromUser(String user);

    public void updateBalance(String user, Float amount);

    public void endAccount(String user);

}
