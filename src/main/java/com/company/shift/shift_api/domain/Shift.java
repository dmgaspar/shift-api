package com.company.shift.shift_api.domain;

import com.company.shift.shift_api.dto.OperatorDTO;
import com.company.shift.shift_api.dto.ShiftDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_shift_id", nullable = false)
    @JsonBackReference
    private DayShift dayShift;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "shift_name", nullable = false)
    private String name;

    @Column(name = "shift_number", nullable = false)
    private Integer shiftNumber;

    @ManyToMany
    @JoinTable(
            name = "shift_operators",
            joinColumns = @JoinColumn(name = "shift_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id")
    )
    private List<Operator> operators = new ArrayList<>();

    public Shift() {
    }

    public Shift(final LocalTime startTime, final LocalTime endTime, final String name, final Integer shiftNumber, final DayShift dayShift, final List<Operator> operators) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.shiftNumber = shiftNumber;
        this.dayShift = dayShift;
        this.operators = operators;
    }

    public Long getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public Integer getShiftNumber() {
        return shiftNumber;
    }

    public DayShift getDayShift() {
        return dayShift;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setStartTime(final LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(final LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setShiftNumber(final Integer shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public void setDayShift(final DayShift dayShift) {
        this.dayShift = dayShift;
    }

    public void setOperators(final List<Operator> operators) {
        this.operators = operators;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shift shift = (Shift) obj;
        return Objects.equals(startTime, shift.startTime) &&
                Objects.equals(endTime, shift.endTime) &&
                Objects.equals(name, shift.name) &&
                Objects.equals(shiftNumber, shift.shiftNumber) &&
                Objects.equals(dayShift, shift.dayShift) &&
                Objects.equals(operators, shift.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, name, shiftNumber, dayShift, operators);
    }

    public ShiftDTO toDTO() {
        List<OperatorDTO> operatorDTOs = operators.stream()
                .map(operator -> new OperatorDTO(operator.getId(), operator.getName()))
                .toList();

        return new ShiftDTO(id, startTime, endTime, name, shiftNumber, operatorDTOs);
    }

}
