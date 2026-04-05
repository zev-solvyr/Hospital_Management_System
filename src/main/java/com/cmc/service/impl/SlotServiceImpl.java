package com.cmc.service.impl;

import com.cmc.dto.SlotRequestDTO;
import com.cmc.dto.SlotResponseDTO;
import com.cmc.entity.Doctor;
import com.cmc.entity.Slot;
import com.cmc.exception.ConflictException;
import com.cmc.exception.ResourceNotFoundException;
import com.cmc.mapper.SlotMapper;
import com.cmc.repository.DoctorRepository;
import com.cmc.repository.SlotRepository;
import com.cmc.service.SlotService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;
    private final DoctorRepository doctorRepository;

    public SlotServiceImpl(SlotRepository slotRepository, DoctorRepository doctorRepository) {
        this.slotRepository = slotRepository;
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    @Override
    public SlotResponseDTO createSlot(SlotRequestDTO slotRequestDTO) {
        //1. Fetch Doctor based on id
        Doctor doctor=doctorRepository.findById(slotRequestDTO.getDoctorId()).orElseThrow(()->new ResourceNotFoundException("Doctor not Found"));

        //2. Validate time format
        if(slotRequestDTO.getStartTime()==null || slotRequestDTO.getEndTime()==null){
            throw new ConflictException("Start time and End time must not be empty");
        }

        if(!slotRequestDTO.getStartTime().isBefore(slotRequestDTO.getEndTime())){
            throw new ConflictException("Start time must be before End time, Invalid time format");
        }

        // 3. Check overlap (OPTIMIZED)
        boolean isOverlapping = slotRepository.existsOverlappingSlot(slotRequestDTO.getDoctorId(),slotRequestDTO.getStartTime(),slotRequestDTO.getEndTime());

        if (isOverlapping) {
            throw new ConflictException("Slot overlaps with existing slot");
        }

        // 4. Create entity
        Slot slot = new Slot();
        slot.setStartTime(slotRequestDTO.getStartTime());
        slot.setEndTime(slotRequestDTO.getEndTime());
        slot.setDoctor(doctor);

        //5. Save Slot
        Slot savedSlot=slotRepository.save(slot);

        return SlotMapper.toDTO(savedSlot);

    }

    @Override
    public List<SlotResponseDTO> getSlotsByDoctor(Long doctorId) {
        doctorRepository.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("Doctor not found"));
        return slotRepository.findByDoctorDoctorId(doctorId).stream().map(SlotMapper::toDTO).toList();
    }
}
