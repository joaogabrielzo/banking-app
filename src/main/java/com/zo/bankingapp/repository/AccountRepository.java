package com.zo.bankingapp.repository;

import com.zo.bankingapp.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
