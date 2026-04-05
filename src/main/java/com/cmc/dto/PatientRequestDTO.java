package com.cmc.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String mobileNumber;

    @NotNull
    private LocalDate dateOfBirth;

    @Email
    @NotBlank
    private String email;
}
