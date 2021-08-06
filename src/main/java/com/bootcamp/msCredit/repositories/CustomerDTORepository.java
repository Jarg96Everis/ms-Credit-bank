package com.bootcamp.msCredit.repositories;

import com.bootcamp.msCredit.entities.CustomerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerDTORepository extends ReactiveMongoRepository<CustomerDTO,String> {
}
