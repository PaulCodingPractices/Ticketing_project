package com.example.Ticketing_project.serviceTests;

import com.example.Ticketing_project.mapper.TicketMapper;
import com.example.Ticketing_project.mapper.UserMapper;
import com.example.Ticketing_project.repository.UserRepository;
import com.example.Ticketing_project.servce.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetAllUsers() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        UserMapper mockUserMapper = Mockito.mock(UserMapper.class);
        TicketMapper mockTicketMapper = Mockito.mock(TicketMapper.class);

        UserService userService = new UserService(mockRepository, mockUserMapper, mockTicketMapper);

        userService.getAllUsers();

        verify(mockRepository).findAll();
    }
}