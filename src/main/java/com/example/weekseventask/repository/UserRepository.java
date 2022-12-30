package com.example.weekseventask.repository;

import com.example.weekseventask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailContaining(String email);
}
