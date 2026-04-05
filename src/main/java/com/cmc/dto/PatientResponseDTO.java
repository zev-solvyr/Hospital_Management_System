package com.cmc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDTO {

    private Long patientId;

    private String name;

    private String mobileNumber;

    private LocalDate dateOfBirth;

    private String email;

    private String registrationNumber;

    private LocalDate registeredDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}