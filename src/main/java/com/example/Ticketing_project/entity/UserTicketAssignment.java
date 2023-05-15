package com.example.Ticketing_project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_product")
public class UserTicketAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public void setUser(User user) {
        this.user = user;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return this.user;
    }

    public Ticket getTicket() {
        return this.ticket;
    }
}
