package com.cmc.controller;

import com.cmc.dto.SlotRequestDTO;
import com.cmc.dto.SlotResponseDTO;
import com.cmc.entity.Slot;
import com.cmc.service.impl.SlotServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {
    private final SlotServiceImpl slotService;


    public SlotController(SlotServiceImpl slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public ResponseEntity<SlotResponseDTO> createSlot(@RequestParam Long doctorId, @RequestBody SlotRequestDTO slotRequestDTO){
        return ResponseEntity.ok(slotService.createSlot(slotRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<SlotResponseDTO>>  getAllSlotsByDoctor(@RequestParam Long doctorId){
        return ResponseEntity.ok(slotService.getSlotsByDoctor(doctorId)) ;
    }
}
