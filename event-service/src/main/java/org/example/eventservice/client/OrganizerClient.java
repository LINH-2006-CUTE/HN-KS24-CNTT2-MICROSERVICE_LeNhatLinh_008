package org.example.eventservice.client;

import org.example.eventservice.dto.OrganizerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organizer-service")
public interface OrganizerClient {

    @GetMapping("/api/organizers/{id}")
    OrganizerDTO getOrganizerById(@PathVariable("id") Long id);
}
