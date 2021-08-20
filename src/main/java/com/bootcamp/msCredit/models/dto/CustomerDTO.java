package com.bootcamp.msCredit.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Customer dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
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
