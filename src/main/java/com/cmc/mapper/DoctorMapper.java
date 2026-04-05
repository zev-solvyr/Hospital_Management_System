package com.cmc.mapper;

import com.cmc.dto.DoctorRequestDTO;
import com.cmc.dto.DoctorResponseDTO;
import com.cmc.entity.Doctor;

public class DoctorMapper {

    public static Doctor toEntity(DoctorRequestDTO doctorRequestDTO){

        Doctor doctor=new Doctor();

        doctor.setName(doctorRequestDTO.getName());
        doctor.setEmail(doctorRequestDTO.getEmail());
        doctor.setSpecialization(doctorRequestDTO.getSpecialization());
        doctor.setMobileNumber(doctorRequestDTO.getMobileNumber());

        return doctor;
    }

    public static DoctorResponseDTO toDTO(Doctor doctor){
        DoctorResponseDTO doctorResponseDTO=new DoctorResponseDTO();

        doctorResponseDTO.setDoctorId(doctor.getDoctorId());
        doctorResponseDTO.setName(doctor.getName());
        doctorResponseDTO.setEmail(doctor.getEmail());
        doctorResponseDTO.setSpecialization(doctor.getSpecialization());
        doctorResponseDTO.setMobileNumber(doctor.getMobileNumber());
        doctorResponseDTO.setCreatedAt(doctor.getCreatedAt());
        doctorResponseDTO.setUpdatedAt(doctor.getUpdatedAt());
        doctorResponseDTO.setRegistrationNumber(doctor.getRegistrationNumber());

        return doctorResponseDTO;
    }
}
