package com.example.Ticketing_project.servce;

import com.example.Ticketing_project.DTO.TicketDTO;
import com.example.Ticketing_project.entity.Ticket;
import com.example.Ticketing_project.mapper.TicketMapper;
import com.example.Ticketing_project.repository.TicketRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return ticketMapper.toDtoList(tickets);
    }

    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
        return ticketMapper.toDto(ticket);
    }
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(savedTicket);
    }



    // Update
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
        ticketDTO.setId(id);
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticketRepository.save(ticket);
        return ticketMapper.toDto(ticket);
    }

    // Delete
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}
