package com.eventMenagement.eventMenagement.entity;

import com.eventMenagement.eventMenagement.entity.enums.UserEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.io.Serial;

@Entity
public class User {

    @Serial
    private static final long serialVersionUID = 1L;

    public User(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private UserEnum role;
}
