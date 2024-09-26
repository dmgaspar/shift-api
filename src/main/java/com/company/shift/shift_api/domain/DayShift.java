package com.company.shift.shift_api.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_day_shift")
public class DayShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id", nullable = false)
    private Long id;

    @Column(name = "day", nullable = false)
    private LocalDateTime day;

    @OneToMany(mappedBy = "dayShift", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Shift> shifts = new ArrayList<>();

    public DayShift() {
    }

    public DayShift(final LocalDateTime day, final List<Shift> shifts) {
        this.day = day;
        this.shifts = shifts;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setDay(final LocalDateTime day) {
        this.day = day;
    }

    public void setShifts(final List<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DayShift dayShift = (DayShift) obj;
        return Objects.equals(day, dayShift.day) &&
                Objects.equals(shifts, dayShift.shifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, shifts);
    }

}
