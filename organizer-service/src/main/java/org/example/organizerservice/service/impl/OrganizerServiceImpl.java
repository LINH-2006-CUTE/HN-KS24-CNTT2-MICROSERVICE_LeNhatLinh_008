package org.example.organizerservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.organizerservice.dto.OrganizerRequestDTO;
import org.example.organizerservice.dto.OrganizerResponseDTO;
import org.example.organizerservice.entity.Organizer;
import org.example.organizerservice.exception.OrganizerNotFoundException;
import org.example.organizerservice.repository.OrganizerRepository;
import org.example.organizerservice.service.OrganizerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

    private final OrganizerRepository organizerRepository;

    @Override
    public OrganizerResponseDTO getOrganizerById(Long id) {
        Organizer organizer = organizerRepository.findById(id)
                .orElseThrow(() -> new OrganizerNotFoundException("Ban tổ chức k hợp lệ "));
        return mapToDTO(organizer);
    }

    @Override
    public List<OrganizerResponseDTO> getAllOrganizers() {
        return organizerRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public OrganizerResponseDTO createOrganizer(OrganizerRequestDTO requestDTO) {
        Organizer organizer = Organizer.builder()
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .phone(requestDTO.getPhone())
                .build();
        Organizer saved = organizerRepository.save(organizer);
        return mapToDTO(saved);
    }

    private OrganizerResponseDTO mapToDTO(Organizer organizer) {
        return OrganizerResponseDTO.builder()
                .id(organizer.getId())
                .name(organizer.getName())
                .email(organizer.getEmail())
                .phone(organizer.getPhone())
                .build();
    }
}
