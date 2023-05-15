package com.example.Ticketing_project.mapper;

import com.example.Ticketing_project.DTO.TicketDTO;
import com.example.Ticketing_project.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(source = "createdBy.id", target = "createdBy")
    @Mapping(source = "assignedTo.id", target = "assignedTo")
    TicketDTO toDto(Ticket ticket);

    @Mapping(source = "createdBy", target = "createdBy.id")
    @Mapping(source = "assignedTo", target = "assignedTo.id")
    Ticket toEntity(TicketDTO ticketDTO);

    List<TicketDTO> toDtoList(List<Ticket> tickets);

    List<Ticket> toEntityList(List<TicketDTO> ticketDTOs);


}
