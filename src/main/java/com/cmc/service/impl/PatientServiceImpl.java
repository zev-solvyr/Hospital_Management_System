package com.cmc.service.impl;

import com.cmc.dto.PatientRequestDTO;
import com.cmc.dto.PatientResponseDTO;
import com.cmc.entity.Patient;
import com.cmc.exception.ConflictException;
import com.cmc.exception.ResourceNotFoundException;
import com.cmc.mapper.PatientMapper;
import com.cmc.repository.PatientRepository;
import com.cmc.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }



    @Transactional
    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        Patient patient = PatientMapper.toEntity(patientRequestDTO);

        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new ConflictException("This email already exists " + patient.getEmail());
        }

        Patient savedPatient = patientRepository.save(patient);

        String regNumber = "PN" + String.format("%05d", savedPatient.getPatientId());
        savedPatient.setRegistrationNumber(regNumber);

        return PatientMapper.toDTO(savedPatient);
    }

    @Override
    public PatientResponseDTO getPatient(Long id) {

        Patient patient= patientRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Patient Not Found "+ id));
        return PatientMapper.toDTO(patient);
    }
}
