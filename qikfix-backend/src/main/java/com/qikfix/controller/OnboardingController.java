package com.qikfix.controller;

import com.qikfix.auth.UserProfile;
import com.qikfix.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/onboard")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class OnboardingController {

    private final UserProfileService userProfileService;

    @Autowired
    public OnboardingController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<String> processOnBoarding(@RequestBody UserProfile userProfile) {
        userProfileService.onBoardUser(userProfile);
        return ResponseEntity.ok("User onboarded successfully");
    }

    @GetMapping
    public String showOnBoardingForm() {
        return "onBoarding";
    }
}
