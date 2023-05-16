package com.example.Ticketing_project.entityTests;

import com.example.Ticketing_project.entity.Ticket;
import com.example.Ticketing_project.entity.TicketPriority;
import com.example.Ticketing_project.entity.TicketStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest{

    @Test
    public void testTicket() {
        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setTitle("Test ticket");
        ticket.setDescription("This is a test ticket");
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setPriority(TicketPriority.HIGH);

        LocalDateTime now = LocalDateTime.now();
        ticket.setCreatedAt(now);
        ticket.setUpdatedAt(now);

        assertEquals(1L, ticket.getId());
        assertEquals("Test ticket", ticket.getTitle());
        assertEquals("This is a test ticket", ticket.getDescription());
        assertEquals(TicketStatus.OPEN, ticket.getStatus());
        assertEquals(TicketPriority.HIGH, ticket.getPriority());
        assertEquals(now, ticket.getCreatedAt());
        assertEquals(now, ticket.getUpdatedAt());
    }
}
