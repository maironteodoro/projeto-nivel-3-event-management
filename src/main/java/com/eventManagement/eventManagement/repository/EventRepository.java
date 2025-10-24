package com.eventManagement.eventManagement.repository;


import com.eventManagement.eventManagement.entity.Event;
import com.eventManagement.eventManagement.entity.enums.EventStateEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long> {


    Optional<Event> findByTitle(String title);
    List<Event> findByStatusNot(EventStateEnum eventStateEnum);



}
