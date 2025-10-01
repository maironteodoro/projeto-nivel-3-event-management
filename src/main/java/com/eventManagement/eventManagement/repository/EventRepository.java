package com.eventManagement.eventManagement.repository;


import com.eventManagement.eventManagement.entity.Event;
import com.eventManagement.eventManagement.entity.User;
import com.eventManagement.eventManagement.entity.enums.EventEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long> {


    Optional<Event> findByTitle(String title);
    List<Event> findByStatusNot(EventEnum eventEnum);



}
