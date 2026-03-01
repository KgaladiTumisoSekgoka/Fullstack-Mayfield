package com.mayfield.Mayfield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mayfield.Mayfield.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}