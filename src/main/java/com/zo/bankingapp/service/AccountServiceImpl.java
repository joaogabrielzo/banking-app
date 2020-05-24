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
    public void endAccount(String user) {

        repo.deleteById(user);

    }

}
