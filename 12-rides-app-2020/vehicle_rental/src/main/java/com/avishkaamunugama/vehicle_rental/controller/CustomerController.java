package com.avishkaamunugama.vehicle_rental.controller;

import com.avishkaamunugama.vehicle_rental.model.Customer;
import com.avishkaamunugama.vehicle_rental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")//
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;



    @GetMapping("/customers")
    Collection<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws URISyntaxException {
        Customer result = customerRepository.save(customer);
        return ResponseEntity.created(new URI("/api/schedules"+customer.getId())).body(result);
    }



    @DeleteMapping("/customers/{id}")
    ResponseEntity<?> removeCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
