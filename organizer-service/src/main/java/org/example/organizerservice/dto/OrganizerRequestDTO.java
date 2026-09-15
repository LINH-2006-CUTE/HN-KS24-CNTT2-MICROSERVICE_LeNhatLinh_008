package org.example.organizerservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizerRequestDTO {
    private String name;
    private String email;
    private String phone;
}
