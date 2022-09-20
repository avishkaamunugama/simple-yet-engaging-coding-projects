package com.avishkaamunugama.vehicle_rental.controller;

import com.avishkaamunugama.vehicle_rental.model.Car;
import com.avishkaamunugama.vehicle_rental.model.MotorBike;
import com.avishkaamunugama.vehicle_rental.model.Schedule;
import com.avishkaamunugama.vehicle_rental.model.Vehicle;
import com.avishkaamunugama.vehicle_rental.repository.ScheduleRepository;
import com.avishkaamunugama.vehicle_rental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;



    @GetMapping("/schedules")
    Collection<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    @PostMapping("/schedules")
    ResponseEntity<Schedule> addSchedule(@Valid @RequestBody Schedule schedule) throws URISyntaxException {
        Schedule result = scheduleRepository.save(schedule);
        return ResponseEntity.created(new URI("/api/schedules"+schedule.getId())).body(result);
    }



    @DeleteMapping("/schedules/{id}")
    ResponseEntity<?> removeSchedule(@PathVariable Long id){
        scheduleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
