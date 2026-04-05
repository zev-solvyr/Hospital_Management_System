package com.cmc.service;

import com.cmc.dto.DoctorRequestDTO;
import com.cmc.dto.DoctorResponseDTO;
import com.cmc.entity.Doctor;

import java.util.List;

public interface DoctorService {

    DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);

    DoctorResponseDTO getDoctor(Long id);

    List<DoctorResponseDTO> getAllDoctors();
}
