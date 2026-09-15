package org.example.eventservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRequestDTO {
    private String name;
    private String location;
    private Long organizerId;
}
