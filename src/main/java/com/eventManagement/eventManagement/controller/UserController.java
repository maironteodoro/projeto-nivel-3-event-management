package com.eventManagement.eventManagement.controller;


import com.eventManagement.eventManagement.dto.userDto.CreateUserRequest;
import com.eventManagement.eventManagement.dto.userDto.UpdateUserRequest;
import com.eventManagement.eventManagement.dto.userDto.UserResponse;
import com.eventManagement.eventManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service){
        this. service = service;
    }

    @PostMapping("/admin")
    public UserResponse createAdmin (@RequestBody @Valid CreateUserRequest userRequest){
        return service.createAdmin(userRequest);
    }
    @PostMapping("/client")
    public UserResponse createClient(@RequestBody @Valid CreateUserRequest userRequest){
        return service.createClient(userRequest);
    }
    @GetMapping
    public Page<UserResponse> findAll(Pageable pageable){
        return service.findAll(pageable);

    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public UserResponse updateName(@PathVariable Long id, @RequestBody @Valid UpdateUserRequest userRequest){

        return service.updateName(userRequest);
    }

    @PatchMapping("/{id}")
    public UserResponse deactivate(@PathVariable Long id){
        return service.deactivate(id);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
