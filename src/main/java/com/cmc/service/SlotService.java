package com.cmc.service;

import com.cmc.dto.SlotRequestDTO;
import com.cmc.dto.SlotResponseDTO;
import com.cmc.entity.Slot;

import java.util.List;

public interface SlotService {
    SlotResponseDTO createSlot(SlotRequestDTO slotRequestDTO);

    List<SlotResponseDTO> getSlotsByDoctor(Long doctorId);

}
