package com.qikfix.controller;
import com.qikfix.service.LoginService;
import com.qikfix.auth.Users;
import com.qikfix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> processLogin(@RequestBody Users loginUser) {
        String email = loginUser.getEmail();
        String password = loginUser.getPassword();
        boolean isAuthenticated = loginService.authenticateUser(email, password);

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Login failed: Invalid credentials");
        }
    }
}