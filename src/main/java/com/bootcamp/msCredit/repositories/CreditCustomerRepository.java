package com.bootcamp.msCredit.repositories;

import com.bootcamp.msCredit.models.entities.CreditCustomer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditCustomerRepository extends ReactiveMongoRepository<CreditCustomer,String> {
}
