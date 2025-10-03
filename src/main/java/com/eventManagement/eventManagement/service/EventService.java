package com.eventManagement.eventManagement.service;


import com.eventManagement.eventManagement.dto.eventDto.CreateEventRequest;
import com.eventManagement.eventManagement.dto.eventDto.EventResponse;
import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.entity.Event;
import com.eventManagement.eventManagement.entity.enums.EventEnum;
import com.eventManagement.eventManagement.exception.BusinessException;
import com.eventManagement.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.eventManagement.repository.CategoryRepository;
import com.eventManagement.eventManagement.repository.EventRepository;
import com.eventManagement.mapper.EventMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;
    private final CategoryRepository categoryRepository;
    public EventService(EventRepository repository, EventMapper mapper, CategoryRepository categoryRepository){

        this.repository = repository;
        this.mapper = mapper;
        this.categoryRepository =categoryRepository;
    }


    @PreAuthorize("hasRole('ADMIN')")
    public EventResponse create(CreateEventRequest eventRequest){

        validateDates(eventRequest);

        Event event = mapper.toEntity(eventRequest);

        updateEventStatus(event);

        repository.save(event);

        return mapper.toResponse(event);
    }



    public Page<EventResponse> findAll(Pageable pageable){
        Pageable safePageable = pageable != null ? pageable : Pageable.unpaged();
        return repository.findAll(safePageable)
                .map(mapper::toResponse);
    }


    public EventResponse findById(Long id){
        Event event = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));

        updateEventStatus(event);

        return mapper.toResponse(event);

    }
    public EventResponse findByTitle(String title){
            Event event = repository.findByTitle(title).orElseThrow(
                    () -> new ResourceNotFoundException
                            ("Event", "title", title));;

            updateEventStatus(event);

        return mapper.toResponse(event);

    }




        public  EventResponse update(UpdateEventRequest eventRequest, Long id){
            Event event = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException
                            ("Event", "id", eventRequest.getId()));


            if (eventRequest.getEndDate().isBefore(eventRequest.getStartDate())) {
                throw new BusinessException("End date cannot be before start date");
            }

            mapper.update(eventRequest, event);

            updateEventStatus(event);


            if (eventRequest.getCategoriesIds() != null && !eventRequest.getCategoriesIds().isEmpty()) {
                List<Category> categories = categoryRepository.findAllByIds(eventRequest.getCategoriesIds());
                event.setCategories(categories);
            }

            repository.save(event);
          return  mapper.toResponse(event);
        }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long  id){

        repository.deleteById(id);

    }


    @Scheduled(fixedRate = 60000) // a cada 60 segundos
    public void updateEventStatuses() {
        List<Event> events = repository.findByStatusNot(EventEnum.COMPLETED); // pega só eventos que ainda não terminaram
        events.forEach(event -> {
            EventEnum newStatus = calculateEventStatus(event.getStartDate(), event.getEndDate());
            if (!event.getStatus().equals(newStatus)) {
                event.setStatus(newStatus);
                repository.save(event);
            }
        });
    }

    private EventEnum calculateEventStatus(LocalDateTime startDate, LocalDateTime endDate) {
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(startDate)) {
            return EventEnum.UPCOMING;
        } else if (now.isAfter(endDate)) {
            return EventEnum.COMPLETED;
        } else {
            return EventEnum.ONGOING;
        }
    }
    //atualiza o status
    private void updateEventStatus(Event event) {
        event.setStatus(calculateEventStatus(event.getStartDate(), event.getEndDate()));
    }


   //evento completo?
    public void eventIsCompleted(Long eventId) {


        Event event = repository.findById(eventId).orElseThrow(
                () -> new ResourceNotFoundException
                        ("Event", "id", eventId));
        updateEventStatus(event);

        if (!event.getStatus().equals(EventEnum.COMPLETED)) {
            throw new BusinessException("O evento ainda não foi concluído.");
        }
    }
    private void validateDates(CreateEventRequest eventRequest) {
        if (eventRequest.getEndDate().isBefore(eventRequest.getStartDate())) {
            throw new BusinessException("End date cannot be before start date");
        }
    }

    public Integer getCapacity(Long eventId) {
        return repository.findById(eventId)
                .map(Event::getCapacity)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", eventId));
    }


}
