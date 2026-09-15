package org.example.organizerservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
