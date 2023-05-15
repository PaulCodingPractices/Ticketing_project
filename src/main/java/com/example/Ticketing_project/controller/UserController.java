package com.example.Ticketing_project.controller;

import com.example.Ticketing_project.DTO.TicketDTO;
import com.example.Ticketing_project.DTO.UserDTO;
import com.example.Ticketing_project.servce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        UserDTO updatedUser = userService.createUser(userDTO);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/{userId}/tickets/{ticketId}")
    public ResponseEntity<UserDTO> assignTicketToUser(@PathVariable Long userId, @PathVariable Long ticketId) {
        UserDTO updatedUser = userService.assignTicketToUser(userId, ticketId);
        return ResponseEntity.ok().body(updatedUser);
    }

    @GetMapping("/users/{userId}/tickets")
    public ResponseEntity<List<TicketDTO>> getTicketsAssignedToUser(@PathVariable Long userId) {
        List<TicketDTO> tickets = userService.getTicketsAssignedToUser(userId);
        return ResponseEntity.ok().body(tickets);
    }
}
