package com.cmc.dto;

import com.cmc.enums.AppointmentStatus;
import com.cmc.enums.AppointmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDTO {

    private Long appointmentId;

    private Long patientId;

    private Long slotId;

    private AppointmentStatus status;

    private AppointmentType appointmentType;

    private String notes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
