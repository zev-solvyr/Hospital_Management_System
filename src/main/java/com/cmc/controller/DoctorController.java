package com.cmc.controller;

import com.cmc.dto.DoctorRequestDTO;
import com.cmc.dto.DoctorResponseDTO;
import com.cmc.entity.Doctor;
import com.cmc.service.impl.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorServiceImpl doctorService;


    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    public ResponseEntity<DoctorResponseDTO> createDoctor(@Valid @RequestBody DoctorRequestDTO doctorRequestDTO){
        return ResponseEntity.ok(doctorService.createDoctor(doctorRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctor(id)) ;
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors()) ;
    }
}
