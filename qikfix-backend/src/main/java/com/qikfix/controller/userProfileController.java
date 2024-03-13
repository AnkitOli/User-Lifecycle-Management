package com.qikfix.controller;

import com.qikfix.entities.UserProfile;
import com.qikfix.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-profile")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class userProfileController {
    @Autowired
    private final UserProfileService userProfileService;

    @Autowired
    public userProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<String> userProfileSetupProcess(@RequestBody UserProfile userProfile) {
        userProfileService.setupProfile(userProfile);
        return ResponseEntity.ok("User profile setup completed");
    }

    //@GetMapping("/with-credentials")
//    public ResponseEntity<List<UserProfile>> getAllUserProfilesWithCredentials(){
//    }
}
