package com.qikfix.service;

import com.qikfix.auth.UserProfile;
import com.qikfix.auth.Users;
import com.qikfix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(Users user) {
        userRepository.save(user);
    }


}
