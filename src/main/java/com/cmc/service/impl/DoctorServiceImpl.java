package com.cmc.service.impl;

import com.cmc.dto.DoctorRequestDTO;
import com.cmc.dto.DoctorResponseDTO;
import com.cmc.entity.Doctor;
import com.cmc.exception.ConflictException;
import com.cmc.exception.ResourceNotFoundException;
import com.cmc.mapper.DoctorMapper;
import com.cmc.mapper.PatientMapper;
import com.cmc.repository.DoctorRepository;
import com.cmc.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    @Transactional
    @Override
    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {

        Doctor doctor= DoctorMapper.toEntity(doctorRequestDTO);

        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new ConflictException("This email already exists " + doctor.getEmail());
        }
        Doctor savedDoctor= doctorRepository.save(doctor);

        String regNumber="DN"+ String.format("%05d",savedDoctor.getDoctorId());
        savedDoctor.setRegistrationNumber(regNumber);

        return DoctorMapper.toDTO(savedDoctor);
    }

    @Override
    public DoctorResponseDTO getDoctor(Long id) {


        Doctor doctor= doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not Found"));
        return DoctorMapper.toDTO(doctor);
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        return  doctorRepository.findAll().stream().map(DoctorMapper::toDTO).toList();
    }
}
