package com.proyect.mscustomer.controller;

import com.proyect.mscustomer.model.Customer;
import com.proyect.mscustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/list")
    public Flux<Customer> list(){
        return customerService.findAll();
    }

    @GetMapping("/find/{id}")
    public Mono<Customer> findById(@PathVariable String id){
        return customerService.findById(id);
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<Customer>> create(@RequestBody Customer customer){
        return customerService.create(customer)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<Customer>> update(@RequestBody Customer customer){
        return customerService.update(customer)
                .map(savedCustomer -> new ResponseEntity<>(savedCustomer, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> delete(@PathVariable String id){
        return customerService.delete(id)
                .filter(deleteCustomer -> deleteCustomer)
                .map(deleteCustomer -> new ResponseEntity<>("Customer deleted", HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
