package com.eventManagement.eventManagement.controller;


import com.eventManagement.eventManagement.dto.registrationDto.CreateRegistrationRequest;
import com.eventManagement.eventManagement.dto.registrationDto.RegistrationResponse;
import com.eventManagement.eventManagement.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {


    @Autowired
    private final RegistrationService service;

    public RegistrationController(RegistrationService service){
        this.service = service;
    }

    @PostMapping
    public RegistrationResponse create (@RequestBody @Valid CreateRegistrationRequest registrationRequest){
        return service.create(registrationRequest);

    }


    @GetMapping
    public Page<RegistrationResponse> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("user/{id}")
    public Page<RegistrationResponse> findByUserId(@PathVariable  Long id,Pageable pageable){
        return service.findByUserId(id,pageable);
    }

    @GetMapping("/event/{id}")
    public Page<RegistrationResponse> findByEventId(@PathVariable Long id, Pageable pageable){
        return service.findByEventId(id,pageable);
    }
    @GetMapping("/{id}")
    public RegistrationResponse findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }




}
