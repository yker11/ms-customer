package com.proyect.mscustomer.service;

import com.proyect.mscustomer.model.Customer;
import com.proyect.mscustomer.repository.ICustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {

    WebClient webClientAccount = WebClient.builder().baseUrl("").build();

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Mono<Customer> create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return customerRepository.findById((customer.getId()))
                .flatMap(customer1 -> {
            return customerRepository.save(customer1);
        });
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return customerRepository.findById(id)
                .flatMap(deleteCustomer -> customerRepository.delete(deleteCustomer).then(Mono.just(Boolean.TRUE)))
                .defaultIfEmpty(Boolean.FALSE);
    }
}
