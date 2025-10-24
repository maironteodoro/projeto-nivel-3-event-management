package com.eventManagement.eventManagement.controller;

import com.eventManagement.eventManagement.dto.categoryDto.CategoryResponse;
import com.eventManagement.eventManagement.dto.categoryDto.CreateCategoryRequest;
import com.eventManagement.eventManagement.dto.categoryDto.UpdateCategoryRequest;
import com.eventManagement.eventManagement.dto.eventDto.EventResponse;
import com.eventManagement.eventManagement.dto.eventDto.UpdateEventRequest;
import com.eventManagement.eventManagement.service.CategoryService;
import jakarta.persistence.Entity;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Entity
@RequestMapping("/categories")
public class CategoryController {

   @Autowired
   private final CategoryService service;


    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @PostMapping
    public CategoryResponse create (@RequestBody CreateCategoryRequest categoryRequest){
        return service.create(categoryRequest);
    }

    @GetMapping("/{name}")
    public CategoryResponse findByName(String name){

        return service.findByName(name);
    }

    @GetMapping
    public Page<CategoryResponse> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id){
        return service.findById(id);
    }


    @PutMapping("/{id}")
    public CategoryResponse update(@RequestBody UpdateCategoryRequest categoryRequest, @PathVariable Long id){
        return service.update(categoryRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }





}
