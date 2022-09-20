package com.avishkaamunugama.vehicle_rental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private Instant pickUpDate;
    private Instant dropOffDate;

    //    @JsonIgnore
    @ManyToOne
    private Vehicle vehicle;

    //    @JsonIgnore
    @ManyToOne
    private Customer customer;
}