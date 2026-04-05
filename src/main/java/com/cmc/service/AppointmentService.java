package com.cmc.service;

import com.cmc.dto.AppointmentRequestDTO;
import com.cmc.dto.AppointmentResponseDTO;
import com.cmc.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO);
    List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId);
    AppointmentResponseDTO cancelAppointment(Long appointmentId);
}
