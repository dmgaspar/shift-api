package com.company.shift.shift_api.controller;


import com.company.shift.shift_api.domain.DayShift;
import com.company.shift.shift_api.service.DayShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cpn/days-shift")
public class DayShiftController {

    @Autowired
    private DayShiftService dayShiftService;

    @GetMapping
    public ResponseEntity<List<DayShift>> getAllDayShifts() {
        List<DayShift> dayShifts = dayShiftService.getAllDayShifts();
        return ResponseEntity.ok(dayShifts);
    }

    @GetMapping("/period")
    public ResponseEntity<List<DayShift>> getDayShiftPeriod(
            @RequestParam LocalDateTime initialDayShift,
            @RequestParam LocalDateTime finalDayShift) {

        List<DayShift> dayShiftList = dayShiftService.getDayShiftPeriod(initialDayShift, finalDayShift);
        return ResponseEntity.ok(dayShiftList);
    }

    @PostMapping
    public ResponseEntity<List<DayShift>> createDayShifts(@RequestBody List<DayShift> schedules) {
        List<DayShift> newDayShifts = dayShiftService.createDayShifts(schedules);
        return ResponseEntity.ok(newDayShifts);
    }

    @PostMapping("/one")
    public ResponseEntity<DayShift> createDayShift(@RequestBody DayShift schedule) {
        DayShift newDayShift = dayShiftService.createDayShift(schedule);
        return ResponseEntity.ok(newDayShift);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DayShift> getDayShiftById(@PathVariable Long id) {
        Optional<DayShift> schedule = dayShiftService.getDayShiftById(id);
        return schedule.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DayShift> updateDayShift(@PathVariable Long id, @RequestBody DayShift newSchedule) {
        Optional<DayShift> updatedDayShift = dayShiftService.updateDayShift(id, newSchedule);
        return updatedDayShift.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DayShift> patchSchedule(@PathVariable Long id, @RequestBody DayShift patchData) {
        Optional<DayShift> updatedDayShift = dayShiftService.patchDayShift(id, patchData);
        return updatedDayShift.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
