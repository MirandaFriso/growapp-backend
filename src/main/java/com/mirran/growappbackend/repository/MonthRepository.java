package com.mirran.growappbackend.repository;

import com.mirran.growappbackend.model.Month;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthRepository extends JpaRepository<Month, Long> {
    //DB-funktioner här
}
