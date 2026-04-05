package com.cmc.service.impl;

import com.cmc.dto.AppointmentRequestDTO;
import com.cmc.dto.AppointmentResponseDTO;
import com.cmc.entity.Appointment;
import com.cmc.entity.Patient;
import com.cmc.entity.Slot;
import com.cmc.enums.AppointmentStatus;
import com.cmc.exception.ConflictException;
import com.cmc.exception.ResourceNotFoundException;
import com.cmc.mapper.AppointmentMapper;
import com.cmc.repository.AppointmentRepository;
import com.cmc.repository.PatientRepository;
import com.cmc.repository.SlotRepository;
import com.cmc.service.AppointmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final PatientRepository patientRepository;
    private final SlotRepository slotRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(PatientRepository patientRepository, SlotRepository slotRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.slotRepository = slotRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) {

//        1. Fetch Patient
        Patient patient=patientRepository.findById(appointmentRequestDTO.getPatientId()).orElseThrow(()->new ResourceNotFoundException("Patient Not Found"));

//        2. Fetch Slot
        Slot slot=slotRepository.findById(appointmentRequestDTO.getSlotId()).orElseThrow(()->new ResourceNotFoundException("Slot Not found"));

//        3. Check slot already booked
        if(appointmentRepository.existsBySlotSlotId(appointmentRequestDTO.getSlotId())){
            throw new ConflictException("Slot already Booked");
        }
//       4. Create Appointment

        Appointment appointment=new Appointment();

        appointment.setPatient(patient);
        appointment.setSlot(slot);
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setAppointmentType(appointmentRequestDTO.getAppointmentType());
        appointment.setNotes(appointmentRequestDTO.getNotes());

        Appointment saved=appointmentRepository.save(appointment);

        return AppointmentMapper.toDTO(saved);

    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatient(Long patientId) {
         appointmentRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Appointment Not found"));

         return appointmentRepository.findByPatientPatientId(patientId).stream().map(AppointmentMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public AppointmentResponseDTO cancelAppointment(Long appointmentId) {

        Appointment appointment= appointmentRepository.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("Appointment Not found"));

        if(appointment.getStatus()==AppointmentStatus.CANCELLED){
            throw new ConflictException("Appointment Already Cancelled");
        }
        appointment.setStatus(AppointmentStatus.CANCELLED);
        return AppointmentMapper.toDTO(appointment);
    }
}
