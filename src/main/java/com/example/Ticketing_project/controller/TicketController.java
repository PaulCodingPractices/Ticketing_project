package com.example.Ticketing_project.controller;

import com.example.Ticketing_project.DTO.TicketDTO;
import com.example.Ticketing_project.entity.Ticket;
import com.example.Ticketing_project.servce.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        TicketDTO ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok().body(ticket);
    }

    @PutMapping("/tickets/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        ticketDTO.setId(id);
        TicketDTO updatedTicket = ticketService.createTicket(ticketDTO);
        return ResponseEntity.ok().body(updatedTicket);
    }

    @PostMapping("/tickets")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO createdTicket = ticketService.createTicket(ticketDTO);
        return ResponseEntity.ok().body(createdTicket);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok().body(tickets);
    }

    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().build();
    }


}
