package com.avishkaamunugama.vehicle_rental.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Car extends  Vehicle {


    private int numberOfDoors;
    private int seatingCapacity;
    private double legSpace;
    private double maxLoad;
    private double groundClearance;

}