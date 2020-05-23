package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.Account;
import com.zo.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public void createAccount(String user) {

        repo.save(new Account("@" + user, 0.0));
    }

    @Override
    public double getBalanceFromUser(String user) {

        Optional<Account> account = repo.findById(user);

        if (account.isPresent()) {
            return account.get().getBalance();
        } else throw new RuntimeException("Account not found");
    }

    @Override
    public void endAccount(String user) {

        repo.deleteById(user);

    }

    @Override
    public void deposit(String user, double amount) {

        Thread depositAction = new Thread(() -> {
            increaseBalance(user, amount);
        }, "deposit");

        depositAction.start();
    }

    @Override
    public void withdraw(String user, double amount) {

        Thread withdrawAction = new Thread(() -> {
            decreaseBalance(user, amount);
        }, "withdraw");

        withdrawAction.start();
    }

    @Override
    public void transfer(String user, double amount, String toUser) {

        Thread decreaseAction = new Thread(() -> {
            decreaseBalance(user, amount);
        }, "decrease");

        Thread increaseAction = new Thread(() -> {
            increaseBalance(toUser, amount);
        }, "increase");

        decreaseAction.start();
        increaseAction.start();

    }

    private synchronized void increaseBalance(String user, double amount) {

        double actualBalance = getBalanceFromUser(user);

        double newBalance = actualBalance + amount;

        repo.save(new Account(user, newBalance));
    }

    private synchronized void decreaseBalance(String user, double amount) {

        double actualBalance = getBalanceFromUser(user);

        double newBalance = actualBalance - amount;

        repo.save(new Account(user, newBalance));
    }


}
