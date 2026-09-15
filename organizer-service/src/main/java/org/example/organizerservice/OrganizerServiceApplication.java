package org.example.organizerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrganizerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizerServiceApplication.class, args);
    }
}
