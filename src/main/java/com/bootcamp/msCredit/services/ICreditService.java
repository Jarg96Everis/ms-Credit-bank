package com.bootcamp.msCredit.services;

import com.bootcamp.msCredit.models.dto.CustomerDTO;
import com.bootcamp.msCredit.models.entities.Credit;
import reactor.core.publisher.Mono;

public interface ICreditService extends ICRUDService<Credit,String>{

    public Mono<CustomerDTO> getCustomer(String customerIdentityNumber);
}
