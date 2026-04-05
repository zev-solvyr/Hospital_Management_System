package com.cmc.mapper;

import com.cmc.dto.AppointmentResponseDTO;
import com.cmc.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentResponseDTO toDTO(Appointment appointment){
        AppointmentResponseDTO appointmentResponseDTO=new AppointmentResponseDTO();

        appointmentResponseDTO.setAppointmentId(appointment.getAppointmentId());
        appointmentResponseDTO.setAppointmentType(appointment.getAppointmentType());
        appointmentResponseDTO.setPatientId(appointment.getPatient().getPatientId());
        appointmentResponseDTO.setSlotId(appointment.getSlot().getSlotId());
        appointmentResponseDTO.setStatus(appointment.getStatus());
        appointmentResponseDTO.setNotes(appointment.getNotes());
        appointmentResponseDTO.setCreatedAt(appointment.getCreatedAt());
        appointmentResponseDTO.setUpdatedAt(appointment.getUpdatedAt());

        return appointmentResponseDTO;
    }
}
