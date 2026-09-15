package org.example.eventservice.service.impl;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.example.eventservice.client.OrganizerClient;
import org.example.eventservice.dto.EventRequestDTO;
import org.example.eventservice.dto.EventResponseDTO;
import org.example.eventservice.dto.OrganizerDTO;
import org.example.eventservice.entity.Event;
import org.example.eventservice.exception.OrganizerNotFoundException;
import org.example.eventservice.repository.EventRepository;
import org.example.eventservice.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final OrganizerClient organizerClient;

    @Override
    public List<EventResponseDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EventResponseDTO createEvent(EventRequestDTO requestDTO) {
        try {
            OrganizerDTO organizer = organizerClient.getOrganizerById(requestDTO.getOrganizerId());
            if (organizer == null || organizer.getId() == null) {
                throw new OrganizerNotFoundException("OrganizerId khong ton tai");
            }
        } catch (FeignException.NotFound e) {
            throw new OrganizerNotFoundException("OrganizerId khong ton tai");
        }

        Event event = Event.builder()
                .name(requestDTO.getName())
                .location(requestDTO.getLocation())
                .organizerId(requestDTO.getOrganizerId())
                .build();

        Event savedEvent = eventRepository.save(event);
        return mapToDTO(savedEvent);
    }

    private EventResponseDTO mapToDTO(Event event) {
        return EventResponseDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .location(event.getLocation())
                .organizerId(event.getOrganizerId())
                .build();
    }
}
