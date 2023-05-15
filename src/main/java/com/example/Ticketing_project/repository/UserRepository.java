package com.example.Ticketing_project.repository;

import com.example.Ticketing_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}