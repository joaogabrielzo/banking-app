package com.zo.bankingapp.service;

public interface AccountActions {

    double getBalance(String user);

    void deposit(String user, double amount);

    void withdraw(String user, double amount);

    void transfer(String user, double amount, String toUser);

}
