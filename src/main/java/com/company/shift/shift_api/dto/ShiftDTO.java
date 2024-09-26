package com.company.shift.shift_api.dto;

import java.time.LocalTime;
import java.util.List;

public record ShiftDTO(Long id, LocalTime startTime, LocalTime endTime, String name,
                       int shiftNumber, List<OperatorDTO> operators) {
}
