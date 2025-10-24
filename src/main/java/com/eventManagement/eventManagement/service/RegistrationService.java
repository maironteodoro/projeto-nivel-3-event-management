package com.eventManagement.eventManagement.service;



import com.eventManagement.eventManagement.dto.registrationDto.CreateRegistrationRequest;
import com.eventManagement.eventManagement.dto.registrationDto.RegistrationResponse;
import com.eventManagement.eventManagement.entity.Event;
import com.eventManagement.eventManagement.entity.Registration;
import com.eventManagement.eventManagement.exception.BusinessException;
import com.eventManagement.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.eventManagement.repository.RegistrationRepository;
import com.eventManagement.mapper.RegistrationMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationRepository repository;
    private final RegistrationMapper mapper;
    private final EventService eventService;

    public  RegistrationService(RegistrationRepository repository, RegistrationMapper mapper, EventService eventService){
        this.repository = repository;
        this.mapper = mapper;
        this.eventService = eventService;
    }

    public RegistrationResponse create(CreateRegistrationRequest registrationRequest){
        int capacity = eventService.getCapacity(registrationRequest.getEventId());

        int registrations = repository.countByEventId(registrationRequest.getEventId());

        if(registrations >= capacity){
            throw new BusinessException("Capacidade máxima do evento atingida.");
        }

        if(repository.existsByUserIdAndEventId(registrationRequest.getUserId(),registrationRequest.getEventId())){
            throw new BusinessException("Usuário já registrado!!");
        }

        Registration registration = mapper.toEntity(registrationRequest);
        repository.save(registration);

        return mapper.toResponse(registration);
    }


    public Page<RegistrationResponse> findAll(Pageable pageable){
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    public Page<RegistrationResponse> findByUserId(Long id,Pageable pageable){
        return repository.findByUserId(id, pageable).map(mapper::toResponse);

    }

    public Page<RegistrationResponse> findByEventId(Long id,Pageable pageable){
        return repository.findByEventId(id, pageable).map(mapper::toResponse);


    }


    public RegistrationResponse findById(Long id){
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration", "id", id)));
    }


    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long  id){
        Registration registration = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration", "id", id));
        repository.delete(registration);
    }



}
