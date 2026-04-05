package com.cmc.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SlotResponseDTO {

    private Long slotId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long doctorId;
}
