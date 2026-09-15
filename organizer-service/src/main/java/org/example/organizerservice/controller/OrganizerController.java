package org.example.organizerservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.organizerservice.dto.OrganizerRequestDTO;
import org.example.organizerservice.dto.OrganizerResponseDTO;
import org.example.organizerservice.service.OrganizerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerResponseDTO> getOrganizerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(organizerService.getOrganizerById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrganizerResponseDTO>> getAllOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizers());
    }

    @PostMapping
    public ResponseEntity<OrganizerResponseDTO> createOrganizer(@RequestBody OrganizerRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizerService.createOrganizer(requestDTO));
    }
}
