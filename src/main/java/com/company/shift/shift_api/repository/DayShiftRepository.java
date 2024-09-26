package com.company.shift.shift_api.repository;

import com.company.shift.shift_api.domain.DayShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayShiftRepository extends JpaRepository<DayShift, Long> {

    @Query("SELECT ds FROM DayShift ds WHERE ds.day BETWEEN :startDate AND :endDate")
    public List<DayShift> findDayShiftsInRange(LocalDate startDate, LocalDate endDate);
}
