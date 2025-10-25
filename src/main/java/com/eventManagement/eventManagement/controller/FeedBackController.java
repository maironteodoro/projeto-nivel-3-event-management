package com.eventManagement.eventManagement.controller;


import com.eventManagement.eventManagement.dto.feedBackDto.CreateFeedBackRequest;
import com.eventManagement.eventManagement.dto.feedBackDto.FeedBackResponse;
import com.eventManagement.eventManagement.dto.feedBackDto.UpdateFeedBackRequest;
import com.eventManagement.eventManagement.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
public class FeedBackController {

    @Autowired
    private final FeedBackService service;


    public FeedBackController(FeedBackService service){
        this.service = service;
    }

    @PostMapping
    public FeedBackResponse create(@RequestBody CreateFeedBackRequest feedBackRequest){

        return service.create(feedBackRequest);
    }

    @GetMapping
    public Page<FeedBackResponse> findAll(Pageable pageable){
        return service.findAll(pageable);

    }
    @GetMapping("/{id}")
    public FeedBackResponse findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("author/{id}")
    public Page<FeedBackResponse> findByAuthorId(Pageable pageable,@PathVariable Long id){

        return service.findByAuthorId(pageable,id);
    }

    @GetMapping("event/{id}")
    public Page<FeedBackResponse> findByEventId(Pageable pageable,@PathVariable Long id){

        return  service.findByEventId(pageable,id);
    }

    @PutMapping("/{id}")
    public FeedBackResponse update (@RequestBody UpdateFeedBackRequest feedBackRequest,@PathVariable Long id){
        return service.update(feedBackRequest,id);
    }

    @DeleteMapping("/{id}")
    public FeedBackResponse delete (@PathVariable Long id){
        return service.delete(id);

    }


}
