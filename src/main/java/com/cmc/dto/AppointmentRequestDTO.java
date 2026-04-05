package com.cmc.dto;

import com.cmc.enums.AppointmentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDTO {

    @NotNull
    private Long patientId;

    @NotNull
    private Long slotId;

    @NotNull
    private AppointmentType appointmentType;

    private String notes;
}