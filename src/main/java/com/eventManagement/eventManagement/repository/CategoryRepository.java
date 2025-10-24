package com.eventManagement.eventManagement.repository;


import com.eventManagement.eventManagement.entity.Category;
import com.eventManagement.eventManagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String name);
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
    List<Category> findAllByIdIn(List<Long> ids);
    }
