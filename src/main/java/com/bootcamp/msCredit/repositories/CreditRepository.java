package com.bootcamp.msCredit.repositories;

import com.bootcamp.msCredit.models.entities.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepository extends ReactiveMongoRepository<Credit,String> {
}
