package org.example.eventservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventservice.dto.EventRequestDTO;
import org.example.eventservice.dto.EventResponseDTO;
import org.example.eventservice.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventRequestDTO requestDTO) {
        EventResponseDTO createdEvent = eventService.createEvent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }
}
