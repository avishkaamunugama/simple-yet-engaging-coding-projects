package com.avishkaamunugama.vehicle_rental.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({     //we can not instantiate objects of an abstract class, and then we have to map these objects against concrete classes
        @JsonSubTypes.Type(value = Car.class,name = "car"),
        @JsonSubTypes.Type(value = MotorBike.class,name = "motorbike")

})
public abstract  class Vehicle {

    @Id
    @NonNull
    private String plateNo;
    private double engineCapacity;
    private String make;
    private String model;
    private boolean availability;
    private String fuelConsumption;
    private String transmission;

}