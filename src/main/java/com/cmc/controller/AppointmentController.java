package com.cmc.controller;

import com.cmc.dto.AppointmentRequestDTO;
import com.cmc.dto.AppointmentResponseDTO;
import com.cmc.entity.Appointment;
import com.cmc.entity.Patient;
import com.cmc.service.impl.AppointmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentServiceImpl appointmentService;


    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> bookAppointment(@Valid @RequestBody AppointmentRequestDTO appointmentRequestDTO){
        return ResponseEntity.ok(appointmentService.bookAppointment(appointmentRequestDTO)) ;
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<List<AppointmentResponseDTO>>  getAppointmentByPatient(@PathVariable Long patientId){
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patientId)) ;
    }

    @PutMapping("/{appointmentId}/cancel")
    public AppointmentResponseDTO cancelAppointment(@PathVariable Long appointmentId){
        return appointmentService.cancelAppointment(appointmentId);
    }



}
