package com.cmc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDTO {

    private Long doctorId;

    private String name;

    private String specialization;

    private String mobileNumber;

    private String email;

    private String registrationNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
