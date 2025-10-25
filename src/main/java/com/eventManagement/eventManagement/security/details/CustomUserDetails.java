package com.eventManagement.eventManagement.security.details;

import com.eventManagement.eventManagement.dto.userDto.UserDetailsResponse;
import com.eventManagement.eventManagement.dto.userDto.UserResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.eventManagement.eventManagement.entity.User;

import java.util.Collection;
import java.util.List;






public class CustomUserDetails implements UserDetails {


    private final UserDetailsResponse user;

    public CustomUserDetails(UserDetailsResponse user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Converte o enum role para authority
        return List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
    }

    @Override
    public String getPassword() {return user.getPassword(); }

    @Override
    public String getUsername() {return user.getUserName(); }

    @Override
    public boolean isEnabled() {return user.getActive();}

}
