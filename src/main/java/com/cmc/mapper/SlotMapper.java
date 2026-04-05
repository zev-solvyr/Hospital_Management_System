package com.cmc.mapper;

import com.cmc.dto.SlotResponseDTO;
import com.cmc.entity.Slot;

public class SlotMapper {
    public static SlotResponseDTO toDTO(Slot slot){

        SlotResponseDTO slotResponseDTO=new SlotResponseDTO();

        slotResponseDTO.setSlotId(slot.getSlotId());
        slotResponseDTO.setStartTime(slot.getStartTime());
        slotResponseDTO.setEndTime(slot.getEndTime());
        slotResponseDTO.setDoctorId(slot.getDoctor().getDoctorId());
        return slotResponseDTO;
    }
}
