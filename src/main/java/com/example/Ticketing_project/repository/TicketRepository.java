package com.example.Ticketing_project.repository;

import com.example.Ticketing_project.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}