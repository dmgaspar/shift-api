package com.company.shift.shift_api.domain;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id", nullable = false)
    private Long id;

    @Column(name = "operator_name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "operators", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shift> shifts = new ArrayList<>();

    // Constructors for Spring and others
    public Operator() {
    }

    public Operator(long id, final String name, final List<Shift> shifts) {
        this.id = id;
        this.name = name;
        this.shifts = shifts;
    }

    public Operator(final String name, final List<Shift> shifts) {
        this.name = name;
        this.shifts = shifts;
    }

    public void setOperator(Operator operator){
        this.name = operator.getName();
        this.shifts = operator.getShifts();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setShifts(final List<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Operator operator = (Operator) obj;
        return Objects.equals(name, operator.name) &&
                Objects.equals(shifts, operator.shifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shifts);
    }
}
