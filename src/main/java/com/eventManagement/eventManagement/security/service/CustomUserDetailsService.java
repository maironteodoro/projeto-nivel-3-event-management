package com.eventManagement.eventManagement.security.details;

import com.eventManagement.eventManagement.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailsService implements CustomUserDetails {


    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }
}
