package com.zo.bankingapp.repository;

import com.zo.bankingapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
