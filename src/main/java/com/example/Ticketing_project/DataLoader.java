package com.example.Ticketing_project;

import com.example.Ticketing_project.entity.Ticket;
import com.example.Ticketing_project.entity.TicketPriority;
import com.example.Ticketing_project.entity.TicketStatus;
import com.example.Ticketing_project.entity.User;
import com.example.Ticketing_project.repository.TicketRepository;
import com.example.Ticketing_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create some users
        User user1 = new User(1L, "John", "Doe", "john.doe@example.com", "password123", new ArrayList<>());
        User user2 = new User(2L, "Jane", "Doe", "jane.doe@example.com", "password456", new ArrayList<>());

        userRepository.saveAll(Arrays.asList(user1, user2));

        // Create some tickets
        LocalDateTime now = LocalDateTime.now();
        Ticket ticket1 = new Ticket(1L, "Ticket 1", "This is ticket 1", TicketStatus.OPEN, TicketPriority.MEDIUM, user1, user2, now, now);
        Ticket ticket2 = new Ticket(2L, "Ticket 2", "This is ticket 2", TicketStatus.OPEN, TicketPriority.HIGH, user2, null, now, now);

        ticketRepository.saveAll(Arrays.asList(ticket1, ticket2));
    }
    }

