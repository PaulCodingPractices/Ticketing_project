package com.example.Ticketing_project.repository;

import com.example.Ticketing_project.entity.User;
import com.example.Ticketing_project.entity.UserTicketAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTicketAssignmentRepository extends JpaRepository<UserTicketAssignment, Long> {
    List<UserTicketAssignment> findByUser(User user);
}