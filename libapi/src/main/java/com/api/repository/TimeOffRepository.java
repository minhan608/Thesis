package com.api.repository;

import com.api.entity.TimeOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeOffRepository extends JpaRepository<TimeOff, Integer> {
}
