package com.qikfix.repository;

import com.qikfix.auth.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{
    Optional<Object> findById(UserProfile id);
    Optional<UserProfile> findByEmail(String email);

}
