package com.eventManagement.eventManagement.controller;


import com.eventManagement.eventManagement.dto.eventDto.CreateEventRequest;
import com.eventManagement.eventManagement.dto.eventDto.EventResponse;
import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private final EventService service;
    public EventController (EventService service){
        this.service = service;
    }

    @PostMapping
    public EventResponse create (@RequestBody @Valid CreateEventRequest eventRequest){
        return service.create(eventRequest);
    }

    @GetMapping
    public Page<EventResponse> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/id/{id}")
    public EventResponse findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/title/{title}")
    public EventResponse findByTitle(@PathVariable String title){
        return service.findByTitle(title);
    }

    @PutMapping("/{id}")
    public EventResponse update(@RequestBody UpdateEventRequest eventRequest,@PathVariable Long id){
        return service.update(eventRequest,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
