package com.company.shift.shift_api.repository;

import com.company.shift.shift_api.domain.LastUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastUpdateRepository extends JpaRepository<LastUpdate, Long> {
}