package com.qikfix.service;

import com.qikfix.auth.UserProfile;
import com.qikfix.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    private static UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository= userProfileRepository;
    }

    @Override
    public void onBoardUser(UserProfile userProfile) {

        userProfileRepository.save(userProfile);
    }
}
