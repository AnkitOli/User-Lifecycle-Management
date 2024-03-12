package com.qikfix.service;

import com.qikfix.auth.Users;
import com.qikfix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String email, String password) {
        Users user = userRepository.findByEmail(email).orElse(null);
        return user != null && user.getPassword().equals(password);

    }
}
