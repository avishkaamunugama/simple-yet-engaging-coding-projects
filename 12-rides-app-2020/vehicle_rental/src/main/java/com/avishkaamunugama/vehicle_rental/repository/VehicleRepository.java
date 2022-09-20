package com.avishkaamunugama.vehicle_rental.repository;

import com.avishkaamunugama.vehicle_rental.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Vehicle findByPlateNo(String plateNo);
}
