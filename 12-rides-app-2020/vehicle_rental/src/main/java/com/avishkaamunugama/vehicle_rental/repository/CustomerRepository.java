package com.avishkaamunugama.vehicle_rental.repository;

import com.avishkaamunugama.vehicle_rental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
