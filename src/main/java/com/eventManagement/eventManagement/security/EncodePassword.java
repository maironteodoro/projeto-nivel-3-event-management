package com.eventManagement.eventManagement.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {


    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "12345";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}