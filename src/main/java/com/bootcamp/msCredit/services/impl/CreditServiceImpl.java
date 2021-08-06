package com.bootcamp.msCredit.services.impl;

import com.bootcamp.msCredit.entities.Credit;
import com.bootcamp.msCredit.repositories.CreditRepository;
import com.bootcamp.msCredit.services.ICreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements ICreditService {

    @Autowired
    private CreditRepository repository;

    @Override
    public Mono<Credit> create(Credit credit) {
        return repository.save(credit);
    }

    @Override
    public Flux<Credit> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Credit> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Credit> update(String id, Credit credit) {
        return repository.findById(id).flatMap( c -> {
            if (c == null){
                return null;
            }
            c.setCapital(credit.getCapital());
            c.setCreditLifeIns(credit.getCreditLifeIns());
            c.setCommission(credit.getCommission());
            c.setInterestRate(credit.getInterestRate());
            c.setNumOfInstallments(credit.getNumOfInstallments());

            return Mono.just(c);
        });
    }

    @Override
    public Mono<Void> delete(Credit credit) {
        return repository.delete(credit);
    }
}
