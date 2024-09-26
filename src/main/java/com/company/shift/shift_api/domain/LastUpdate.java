package com.company.shift.shift_api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_last_update")
public class LastUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id", nullable = false)
    private Long id;

    @Column(name = "ds_lastUpdate")
    private LocalDateTime lastDateUpdate;

    // Constructors
    public LastUpdate() {
    }

    public LastUpdate(final Long id, final LocalDateTime lastDateUpdate) {
        this.id = id;
        this.lastDateUpdate = lastDateUpdate;
    }

    public LastUpdate(final LocalDateTime lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getLastDateUpdate() {
        return lastDateUpdate;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setLastDateUpdate(final LocalDateTime lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    // Equals and hashCode
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LastUpdate that = (LastUpdate) obj;
        return Objects.equals(lastDateUpdate, that.lastDateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastDateUpdate);
    }
}

