package com.cmc.service;

import com.cmc.dto.PatientRequestDTO;
import com.cmc.dto.PatientResponseDTO;
import com.cmc.entity.Patient;

public interface PatientService {

     PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
     PatientResponseDTO getPatient(Long id);
}
