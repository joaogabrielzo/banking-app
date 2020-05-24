package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.User;
import com.zo.bankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public User createUser(User user) {

        User userWithPasswordEncoded = encryptPassword(user);

        repo.save(userWithPasswordEncoded);
        return userWithPasswordEncoded;
    }

    private User encryptPassword(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User userPasswordEncoded = new User();
        userPasswordEncoded.setUsername(user.getUsername());
        userPasswordEncoded.setPassword(encoder.encode(user.getPassword()));

        return userPasswordEncoded;
    }

    @Override
    public User changePassword(User user) {

        Optional<User> actualUser = repo.findById(user.getUsername());

        if (actualUser.isPresent()) {
            return createUser(user);
        } else throw new RuntimeException("User not found.");
    }

    @Override
    public void deleteUser(String user) {

        repo.deleteById(user);
    }

}
