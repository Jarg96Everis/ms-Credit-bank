package com.bootcamp.msCredit.services;

import com.bootcamp.msCredit.models.dto.CustomerDTO;
import com.bootcamp.msCredit.models.entities.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The interface Credit service.
 */
public interface ICreditService extends ICRUDService<Credit,String>{

    /**
     * Gets customer.
     *
     * @param customerIdentityNumber the customer identity number
     * @return the customer
     */
    public Mono<CustomerDTO> getCustomer(String customerIdentityNumber);

    /**
     * Find all by customer identity number flux.
     *
     * @param customerIdentityNumber the customer identity number
     * @return the flux
     */
    public Flux<Credit> findAllByCustomerIdentityNumber(String customerIdentityNumber);
}
