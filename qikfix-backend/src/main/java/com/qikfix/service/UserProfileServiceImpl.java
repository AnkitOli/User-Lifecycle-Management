package com.qikfix.service;

import com.qikfix.entities.UserProfile;
import com.qikfix.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    private static UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository= userProfileRepository;
    }
    @Override
    public void setupProfile(UserProfile userProfile) {

        userProfileRepository.save(userProfile);
    }
    public List<UserProfile> getAllUserProfiles(){
        return userProfileRepository.findAll();
    }
    public UserProfile getUserProfileById(Long id){
        Optional<UserProfile> userProfileOptional= userProfileRepository.findById(id);
        return userProfileOptional.orElse(null);
    }
}
