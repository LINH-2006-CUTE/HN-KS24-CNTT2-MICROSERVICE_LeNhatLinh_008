package org.example.eventservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
