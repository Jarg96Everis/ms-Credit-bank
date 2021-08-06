package com.bootcamp.msCredit.services.impl;

import com.bootcamp.msCredit.entities.CustomerDTO;
import com.bootcamp.msCredit.repositories.CustomerDTORepository;
import com.bootcamp.msCredit.services.ICustomerDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerDTOServiceImpl implements ICustomerDTOService {

    @Autowired
    private CustomerDTORepository repository;

    @Override
    public Mono<CustomerDTO> create(CustomerDTO customerDTO) {
        return repository.save(customerDTO);
    }

    @Override
    public Flux<CustomerDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CustomerDTO> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<CustomerDTO> update(String id, CustomerDTO customerDTO) {
        return repository.findById(id).flatMap( c -> {
            if (c == null){
                return null;
            }
            c.setName(customerDTO.getName());
            c.setSurname(customerDTO.getSurname());
            c.setCustomerType(customerDTO.getCustomerType());

            return Mono.just(c);
        });
    }

    @Override
    public Mono<Void> delete(CustomerDTO customerDTO) {
        return repository.delete(customerDTO);
    }
}
