package com.eventManagement.eventManagement.service;


import com.eventManagement.eventManagement.dto.feedBackDto.CreateFeedBackRequest;
import com.eventManagement.eventManagement.dto.feedBackDto.UpdateFeedBackRequest;
import com.eventManagement.eventManagement.dto.feedBackDto.FeedBackResponse;
import com.eventManagement.eventManagement.entity.FeedBack;
import com.eventManagement.eventManagement.exception.BusinessException;
import com.eventManagement.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.eventManagement.repository.FeedBackRepository;
import com.eventManagement.mapper.FeedBackMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {

    private final FeedBackRepository repository;
    private final FeedBackMapper mapper;
    private final EventService eventService;
    public FeedBackService(FeedBackRepository repository, FeedBackMapper mapper,EventService eventService){
        this.repository = repository;
        this.mapper = mapper;
        this.eventService = eventService;
    }

    public FeedBackResponse create(CreateFeedBackRequest feedBackRequest){
        if(repository.findByAuthorIdAndEventId(feedBackRequest.getAuthorId(), feedBackRequest.getEventId()).isPresent()){
            throw new BusinessException("Usuário já enviou feedback para este evento.");
        }
        eventService.isEventCompleted(feedBackRequest.getEventId());
        FeedBack feedback = mapper.toEntity(feedBackRequest);
        repository.save(feedback);
        return mapper.toResponse(feedback);
    }

    public Page<FeedBackResponse> findAll(Pageable pageable){
        return  repository.findAll(pageable).map(mapper::toResponse);
    }

    public FeedBackResponse findById(Long id){
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("feedback", "id", id)));
    }

    public Page<FeedBackResponse> findByAuthorId(Pageable pageable,Long id){

        return repository.findByAuthorId(id,pageable).map(mapper::toResponse);
    };
    public Page<FeedBackResponse> findByEventId(Pageable pageable,Long id){

        return repository.findByEventId(id,pageable).map(mapper::toResponse);
    };

    public FeedBackResponse update (UpdateFeedBackRequest feedBackRequest){
        FeedBack feedback = repository.findById(feedBackRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("feedback", "id",feedBackRequest.getId()));
        mapper.update(feedBackRequest,feedback);
        return mapper.toResponse(feedback);
    }


    @PreAuthorize("hasRole('ADMIN')")
    public FeedBackResponse delete(Long  id){
        FeedBack feedback = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("feedback", "id", id));
        repository.delete(feedback);
        return mapper.toResponse(feedback);
    }
}
