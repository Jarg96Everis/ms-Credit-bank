package com.bootcamp.msCredit.services.impl;

import com.bootcamp.msCredit.entities.CreditCustomer;
import com.bootcamp.msCredit.repositories.CreditCustomerRepository;
import com.bootcamp.msCredit.services.ICreditCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCustomerServiceImpl implements ICreditCustomerService {

    @Autowired
    private CreditCustomerRepository repository;

    @Override
    public Mono<CreditCustomer> create(CreditCustomer creditCustomer) {
        return repository.save(creditCustomer);
    }

    @Override
    public Flux<CreditCustomer> findAll() {
        return null;
    }

    @Override
    public Mono<CreditCustomer> findById(String id) {
        return null;
    }

    @Override
    public Mono<CreditCustomer> update(String id, CreditCustomer creditCustomer) {
        return repository.findById(id).flatMap( c -> {
            if (c == null){
                return null;
            }
            c.setCustomer(creditCustomer.getCustomer());
            c.setCredit(creditCustomer.getCredit());

            return Mono.just(c);
        });
    }

    @Override
    public Mono<Void> delete(CreditCustomer creditCustomer) {
        return null;
    }
}
