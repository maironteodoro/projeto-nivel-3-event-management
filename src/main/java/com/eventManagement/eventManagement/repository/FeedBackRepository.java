package com.eventManagement.eventManagement.repository;

import com.eventManagement.eventManagement.entity.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedBackRepository extends JpaRepository<FeedBack,Long> {



    Page<FeedBack> findByEventId(Long eventId,  Pageable pageable);
    Page<FeedBack> findByAuthorId(Long authorId, Pageable pageable);
    Optional<FeedBack> findByAuthorIdAndEventId(Long autohrId, Long eventId);

}
