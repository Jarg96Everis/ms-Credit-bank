package com.bootcamp.msCredit.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * The type Customer dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    /**
     * @ID is the unique identification of CustomerDTO.
     * */
    private String id;
    /**
     * @name is the field that represent the name of the customer.
     */
    private String name;
    private String customerIdentityType;
    private String customerIdentityNumber;
}
