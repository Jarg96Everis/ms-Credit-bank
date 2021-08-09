package com.bootcamp.msCredit.handler;

import com.bootcamp.msCredit.models.entities.CreditCustomer;
import com.bootcamp.msCredit.services.ICreditCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j(topic = "creditcustomer_handler")
@Component
public class CreditCustomerHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCustomerHandler.class);

    @Autowired
    private ICreditCustomerService service;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), CreditCustomer.class);
    }

    public Mono<ServerResponse> findCreditCustomer(ServerRequest request) {
        String id = request.pathVariable("id");
        return service.findById(id).flatMap((c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(c))
                .switchIfEmpty(ServerResponse.notFound().build()))
        );
    }

    public Mono<ServerResponse> newCreditCustomer(ServerRequest request){

        Mono<CreditCustomer> creditCustomerMono = request.bodyToMono(CreditCustomer.class);

        return creditCustomerMono.flatMap( c -> service.create(c)).flatMap( c -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(c)));
    }

    public Mono<ServerResponse> deleteCreditCustomer(ServerRequest request){

        String id = request.pathVariable("id");

        Mono<CreditCustomer> creditCustomerMono = service.findById(id);

        return creditCustomerMono
                .doOnNext(c -> LOGGER.info("deleteConsumption: consumptionId={}", c.getId()))
                .flatMap(c -> service.delete(c).then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateCreditCustomer(ServerRequest request){
        Mono<CreditCustomer> creditCustomerMono = request.bodyToMono(CreditCustomer.class);
        String id = request.pathVariable("id");

        return service.findById(id).zipWith(creditCustomerMono, (db,req) -> {
                    db.setCustomer(req.getCustomer());
                    db.setCredit(req.getCredit());
                    return db;
                }).flatMap( c -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.create(c),CreditCustomer.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
