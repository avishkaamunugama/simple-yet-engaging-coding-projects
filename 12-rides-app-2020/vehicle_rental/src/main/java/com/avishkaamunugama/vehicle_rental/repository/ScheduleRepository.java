package com.avishkaamunugama.vehicle_rental.repository;

import com.avishkaamunugama.vehicle_rental.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
Optional<Schedule> findById(Long id);
}
