package com.api.v1.individual_customer;

import com.api.v1.customer.RegisterCustomerDTO;
import com.api.v1.dtos.DateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterIndividualCustomerDTO(

    @Pattern(regexp = "[\\d]{9}")
    @NotBlank
    String ssn,

    @NotNull
    DateDTO birthDay,

    @NotNull
    RegisterCustomerDTO customer

) {
    
}
