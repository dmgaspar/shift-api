package com.company.shift.shift_api.service.impl;


import com.company.shift.shift_api.domain.DayShift;
import com.company.shift.shift_api.domain.Shift;
import com.company.shift.shift_api.repository.DayShiftRepository;
import com.company.shift.shift_api.repository.ShiftRepository;
import com.company.shift.shift_api.service.DayShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DayShiftServiceImpl implements DayShiftService {

    @Autowired
    private DayShiftRepository dayShiftRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    public DayShiftServiceImpl(DayShiftRepository dayShiftRepository) {
        this.dayShiftRepository = dayShiftRepository;
    }

    @Override
    public List<DayShift> getDayShiftPeriod(LocalDateTime initialDayShift, LocalDateTime finalDayShift) {

        LocalDate initialDate = initialDayShift.toLocalDate();
        LocalDate endDate = finalDayShift.toLocalDate();

        return dayShiftRepository.findDayShiftsInRange(initialDate, endDate);
    }

    @Override
    public Optional<DayShift> getDayShiftById(Long id) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public DayShift createDayShift(DayShift dayShift) {

        for (Shift shift : dayShift.getShifts()) {
            shift.setDayShift(dayShift); // Set the DayShift reference in each Shift
        }

        return dayShiftRepository.save(dayShift);
    }

    @Override
    public Optional<DayShift> updateDayShift(Long id, DayShift newDayShift) {
        return Optional.empty();
    }

    @Override
    public Optional<DayShift> patchDayShift(Long id, DayShift patchData) {
        return Optional.empty();
    }

    @Override
    public List<DayShift> getAllDayShifts() {
        return dayShiftRepository.findAll();
    }

    @Override
    public List<DayShift> createDayShifts(List<DayShift> schedules) {
        return dayShiftRepository.saveAll(schedules);
    }
}
