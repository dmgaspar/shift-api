package com.company.shift.shift_api.service;

import com.company.shift.shift_api.domain.DayShift;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DayShiftService {

    public List<DayShift> getDayShiftPeriod(LocalDateTime initialDayShift, LocalDateTime finalDayShift);

    public Optional<DayShift> getDayShiftById(Long id);

    public DayShift createDayShift(DayShift dayShift);

    public Optional<DayShift> updateDayShift(Long id, DayShift newDayShift);

    public Optional<DayShift> patchDayShift(Long id, DayShift patchData);

    public List<DayShift> getAllDayShifts();

    List<DayShift> createDayShifts(List<DayShift> schedules);
}