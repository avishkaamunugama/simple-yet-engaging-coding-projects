package com.avishkaamunugama.vehicle_rental.controller;


import com.avishkaamunugama.vehicle_rental.model.Vehicle;
import com.avishkaamunugama.vehicle_rental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;



    @GetMapping("/vehicles")
    Collection<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }


    @PostMapping("/vehicles")
    ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) throws URISyntaxException {
        Vehicle result = vehicleRepository.save(vehicle);
        return ResponseEntity.created(new URI("/api/vehicles/car"+vehicle.getPlateNo())).body(result);
    }



    @DeleteMapping("/vehicles/{id}")
    ResponseEntity<?> removeVehicle(@PathVariable String id){
        vehicleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/Vehicles/{id}")
//    ResponseEntity<Vehicle> editVehicle(@Valid @RequestBody Vehicle vehicle){
//        Vehicle result = vehicleRepository.save(vehicle);
//        return ResponseEntity.ok().body(result);
//    }


}
