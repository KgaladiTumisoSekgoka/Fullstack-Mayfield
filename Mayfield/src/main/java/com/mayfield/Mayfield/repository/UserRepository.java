package com.mayfield.Mayfield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mayfield.Mayfield.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}