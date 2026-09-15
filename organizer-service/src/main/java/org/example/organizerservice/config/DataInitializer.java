package org.example.organizerservice.config;

import lombok.RequiredArgsConstructor;
import org.example.organizerservice.entity.Organizer;
import org.example.organizerservice.repository.OrganizerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final OrganizerRepository organizerRepository;

    @Override
    public void run(String... args) {
        if (organizerRepository.count() == 0) {
            organizerRepository.save(Organizer.builder().name("Ban To Chuc A").email("organizerA@gmail.com").phone("0123456789").build());
            organizerRepository.save(Organizer.builder().name("Ban To Chuc B").email("organizerB@gmail.com").phone("0987654321").build());
            organizerRepository.save(Organizer.builder().name("Ban To Chuc C").email("organizerC@gmail.com").phone("0912345678").build());
        }
    }
}
