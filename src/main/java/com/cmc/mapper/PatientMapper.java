package com.cmc.mapper;

import com.cmc.dto.PatientRequestDTO;
import com.cmc.dto.PatientResponseDTO;
import com.cmc.entity.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static Patient toEntity(PatientRequestDTO patientRequestDTO){
         Patient patient = new Patient();
         patient.setName(patientRequestDTO.getName());
         patient.setEmail(patientRequestDTO.getEmail());
         patient.setMobileNumber(patientRequestDTO.getMobileNumber());
         patient.setDateOfBirth(patientRequestDTO.getDateOfBirth());

         patient.setRegisteredDate(LocalDate.now());

         return patient;
    }

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO=new PatientResponseDTO();

        patientResponseDTO.setPatientId(patient.getPatientId());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth());
        patientResponseDTO.setMobileNumber(patient.getMobileNumber());
        patientResponseDTO.setRegisteredDate(patient.getRegisteredDate());
        patientResponseDTO.setRegistrationNumber(patient.getRegistrationNumber());
        patientResponseDTO.setCreatedAt(patient.getCreatedAt());
        patientResponseDTO.setUpdatedAt(patient.getUpdatedAt());

        return  patientResponseDTO;
    }


}
