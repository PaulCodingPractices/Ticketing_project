package com.example.Ticketing_project.servce;

import com.example.Ticketing_project.DTO.TicketDTO;
import com.example.Ticketing_project.DTO.UserDTO;
import com.example.Ticketing_project.entity.Ticket;
import com.example.Ticketing_project.entity.User;
import com.example.Ticketing_project.entity.UserTicketAssignment;
import com.example.Ticketing_project.mapper.TicketMapper;
import com.example.Ticketing_project.mapper.UserMapper;
import com.example.Ticketing_project.repository.TicketRepository;
import com.example.Ticketing_project.repository.UserRepository;
import com.example.Ticketing_project.repository.UserTicketAssignmentRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TicketMapper ticketMapper;


    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, TicketMapper ticketMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.ticketMapper = ticketMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<User> products = userRepository.findAll();
        return userMapper.toDtoList(products);
    }
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return userMapper.toDto(user);
    }
    // Create
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }



    // Update
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userDTO.setId(id);
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Autowired
    private UserTicketAssignmentRepository userTicketAssignmentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public UserDTO assignTicketToUser(Long userId, Long ticketId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + ticketId));

        UserTicketAssignment userTicketAssignment = new UserTicketAssignment();
        userTicketAssignment.setUser(user);
        userTicketAssignment.setTicket(ticket);

        userTicketAssignmentRepository.save(userTicketAssignment);

        return userMapper.toDto(user);
    }

    public List<TicketDTO> getTicketsAssignedToUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        List<UserTicketAssignment> assignments = userTicketAssignmentRepository.findByUser(user);
        List<Ticket> tickets = assignments.stream().map(UserTicketAssignment::getTicket).collect(Collectors.toList());


        return ticketMapper.toDtoList(tickets);
    }



}
