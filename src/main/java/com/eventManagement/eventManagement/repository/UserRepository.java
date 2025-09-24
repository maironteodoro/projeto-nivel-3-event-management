package com.eventManagement.eventManagement.repository;


import com.eventManagement.eventManagement.dto.userDto.UserDetailsResponse;
import com.eventManagement.eventManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String name);


}
