package com.eventManagement.eventManagement.service;


import com.eventManagement.eventManagement.dto.categoryDto.CategoryResponse;
import com.eventManagement.eventManagement.dto.categoryDto.CreateCategoryRequest;
import com.eventManagement.eventManagement.dto.categoryDto.UpdateCategoryRequest;
import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.exception.BusinessException;
import com.eventManagement.eventManagement.exception.ResourceNotFoundException;
import com.eventManagement.eventManagement.repository.CategoryRepository;
import com.eventManagement.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repository, CategoryMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }


    public CategoryResponse create (CreateCategoryRequest categoryRequest){

        if (!repository.existisByName(categoryRequest.getName())){
            throw new BusinessException("Category already exist.");
        }
        Category category = mapper.toEntity(categoryRequest);
        repository.save(category);
        return mapper.toResponse(category);
    }

    public Page<CategoryResponse> findAll(Pageable pageable){
        Pageable safePageable = pageable != null ? pageable : Pageable.unpaged();
        return repository.findAll(safePageable)
                .map(mapper::toResponse);
    }

    public CategoryResponse findById(Long id){
        Category category = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Category", "id", id));

        return mapper.toResponse(category);

    }

    public CategoryResponse findByName(String name){
       Category category = repository.findByName(name)
               .orElseThrow(()->new ResourceNotFoundException("Category", "name", name));

        return mapper.toResponse(category);
    }

    public CategoryResponse update(UpdateCategoryRequest categoryRequest){


        if (repository.existsByNameAndIdNot(categoryRequest.getName(), categoryRequest.getId())) {
            throw new BusinessException("Category already exists.");
        }

        Category category = repository.findById(categoryRequest.getId())
                .orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryRequest.getId()));

        repository.save(category);
        return mapper.toResponse(category);

    }
    public List<Category> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long  id){

        repository.deleteById(id);

    }


}
