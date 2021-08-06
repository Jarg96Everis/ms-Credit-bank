package com.bootcamp.msCredit.config;

import com.bootcamp.msCredit.handler.CreditCustomerHandler;
import com.bootcamp.msCredit.handler.CreditHandler;
import com.bootcamp.msCredit.handler.CustomerDTOHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(CreditHandler creditHandler,
                                                 CreditCustomerHandler creditCustomerHandler,
                                                 CustomerDTOHandler customerDTOHandler){

        return route(GET("/api/credit"), creditHandler::findAll)
                .andRoute(GET("/api/credit/{id}"), creditHandler::findCredit)
                .andRoute(POST("/api/credit"), creditHandler::newCredit)
                .andRoute(PUT("/api/credit/{id}"), creditHandler::updateCredit)
                .andRoute(DELETE("/api/credit/{id}"), creditHandler::deleteCredit)
                .andRoute(GET("/api/creditcustomer"), creditCustomerHandler::findAll)
                .andRoute(GET("/api/creditcustomer/{id}"), creditCustomerHandler::findCreditCustomer)
                .andRoute(POST("/api/creditcustomer"), creditCustomerHandler::newCreditCustomer)
                .andRoute(PUT("/api/creditcustomer/{id}"), creditCustomerHandler::updateCreditCustomer)
                .andRoute(DELETE("/api/creditcustomer/{id}"), creditCustomerHandler::deleteCreditCustomer)
                .andRoute(GET("/api/customerdto"), customerDTOHandler::findAll)
                .andRoute(GET("/api/customerdto/{id}"), customerDTOHandler::findCustomerDTO)
                .andRoute(POST("/api/customerdto"), customerDTOHandler::newCustomerDTO)
                .andRoute(PUT("/api/customerdto/{id}"), customerDTOHandler::updateCustomerDTO)
                .andRoute(DELETE("/api/customerdto/{id}"), customerDTOHandler::deleteCustomerDTO);

    }

}
