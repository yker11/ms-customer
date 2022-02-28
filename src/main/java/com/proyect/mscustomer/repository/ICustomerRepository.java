package com.proyect.mscustomer.repository;

import com.proyect.mscustomer.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
