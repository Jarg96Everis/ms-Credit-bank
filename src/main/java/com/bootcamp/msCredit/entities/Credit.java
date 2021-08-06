package com.bootcamp.msCredit.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "credit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credit {

    @Id
    private String id;

    private double capital;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createAt;

    private double amountPeMonth;

    private double commission;

    private double interestRate;

    private int numOfInstallments;

    private double creditLifeIns;

    private CustomerDTO customer;
}
