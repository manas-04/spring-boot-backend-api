package com.example.springbootassignment.Repository;

import com.example.springbootassignment.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserId(Long userId);
    Users findByUserName(String userName);
}
