package com.eventManagement.eventManagement.security.service;

import com.eventManagement.eventManagement.dto.userDto.UserDetailsResponse;
import com.eventManagement.eventManagement.dto.userDto.UserResponse;
import com.eventManagement.eventManagement.repository.UserRepository;
import com.eventManagement.eventManagement.security.details.CustomUserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsResponse user = repository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(user);
    }
}
