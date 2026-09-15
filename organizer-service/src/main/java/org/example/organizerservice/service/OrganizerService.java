package org.example.organizerservice.service;

import org.example.organizerservice.dto.OrganizerRequestDTO;
import org.example.organizerservice.dto.OrganizerResponseDTO;

import java.util.List;

public interface OrganizerService {
    OrganizerResponseDTO getOrganizerById(Long id);
    List<OrganizerResponseDTO> getAllOrganizers();
    OrganizerResponseDTO createOrganizer(OrganizerRequestDTO requestDTO);
}
