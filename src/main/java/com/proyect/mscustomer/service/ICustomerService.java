package com.proyect.mscustomer.service;

import com.proyect.mscustomer.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

    public Mono<Customer> create(Customer customer);

    public Flux<Customer> findAll();

    public Mono<Customer> findById(String id);

    public Mono<Customer> update(Customer customer);

    public Mono<Boolean> delete(String id);
}
