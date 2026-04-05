package com.cmc.controller;


import com.cmc.dto.PatientRequestDTO;
import com.cmc.dto.PatientResponseDTO;
import com.cmc.entity.Patient;
import com.cmc.service.PatientService;
import com.cmc.service.impl.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatient(id)) ;
    }
}
