package com.eventManagement.eventManagement.repository;


import com.eventManagement.eventManagement.entity.FeedBack;
import com.eventManagement.eventManagement.entity.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {



    Page<Registration> findByEventId(Long eventId, Pageable pageable);
    Page<Registration> findByUserId(Long userId, Pageable pageable);
    Long countByEventId(Long eventId);
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
}
