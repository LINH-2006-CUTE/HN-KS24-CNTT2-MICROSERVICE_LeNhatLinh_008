package org.example.eventservice.service;

import org.example.eventservice.dto.EventRequestDTO;
import org.example.eventservice.dto.EventResponseDTO;

import java.util.List;

public interface EventService {
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO createEvent(EventRequestDTO requestDTO);
}
