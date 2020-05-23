package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.User;
import com.zo.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public Optional<User> getUser(String username) {

        return repo.findById(username);
    }

    @Override
    public void createUser(User user) {
        repo.save(user);

    }

    @Override
    public void changePassword(User user) {
        Optional<User> actualUser = repo.findById(user.getUsername());

        if (actualUser.isPresent()) {
            repo.save(user);
        } else throw new RuntimeException("User not found.");
    }

    @Override
    public void deleteUser(String user) {
        repo.deleteById(user);
    }

}
