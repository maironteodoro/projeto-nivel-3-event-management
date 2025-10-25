package com.eventManagement.eventManagement.service;

import com.eventManagement.eventManagement.dto.userDto.*;
import com.eventManagement.eventManagement.entity.User;
import com.eventManagement.eventManagement.entity.enums.UserEnum;
import com.eventManagement.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.eventManagement.repository.UserRepository;
import com.eventManagement.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private final UserRepository repository;
    public final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;



    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, UserMapper mapper){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        }

        @PreAuthorize("hasRole('ADMIN')")
    public UserResponse createAdmin(CreateUserRequest userRequest){

        User user = mapper.toEntity(userRequest,passwordEncoder,UserEnum.ADMIN);
        user.setActive(true);
        User savedUser= repository.save(user);
        return mapper.toResponse(savedUser);
    }

    public UserResponse createClient(CreateUserRequest userRequest){
        User user = mapper.toEntity(userRequest,passwordEncoder,UserEnum.PARTICIPANT);
        user.setActive(true);
        User savedUser= repository.save(user);
        return mapper.toResponse(savedUser);
    }

    public Page<UserResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    public UserResponse findById(Long id){
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id)));
    }


    public User findByNameDetails(String name) {

        return repository.findByUserName(name)
                .orElseThrow(() -> new ResourceNotFoundException("user", "name", name));
    }

    public UserResponse updateName (Long id,UpdateUserRequest userRequest){

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userRequest.getId()));

        mapper.update(userRequest, user);
        repository.save(user);
        return mapper.toResponse(user);
    }

    //clareza é priorizada sobre micro otimizações
    public UserResponse deactivate(Long id){

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setActive(false);
        repository.save(user);

        return mapper.toResponse(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long  id){

        repository.deleteById(id);

    }
}
