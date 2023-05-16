package com.example.Ticketing_project.entityTests;

import com.example.Ticketing_project.entity.User;
import com.example.Ticketing_project.entity.Ticket;
import com.example.Ticketing_project.entity.UserTicketAssignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTicketAssignmentTest {

    @Test
    public void testUserTicketAssignment() {
        User user = new User();
        user.setId(1L);

        Ticket ticket = new Ticket();
        ticket.setId(2L);

        UserTicketAssignment userTicketAssignment = new UserTicketAssignment();
        userTicketAssignment.setUser(user);
        userTicketAssignment.setTicket(ticket);

        assertEquals(user, userTicketAssignment.getUser());
        assertEquals(ticket, userTicketAssignment.getTicket());
    }
}
