package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.Account;

public interface AccountService {

    void createAccount(String user);

    double getBalanceFromUser(String user);

    void endAccount(String user);

    void deposit(String user, double amount);

    void withdraw(String user, double amount);

    void transfer(String user, double amount, String toUser);

}
