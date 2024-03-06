package com.api.v1.individual_customer.register;

import com.api.v1.customer.RegisterCustomerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterIndividualCustomerDTO(

    @Pattern(regexp = "[\\d]{9}")
    @NotBlank
    String ssn,

    @Pattern(regexp = "[\\d]{2}/[\\d]{2}/[\\d]{4}")
    @NotBlank
    String birthDay,

    @NotNull
    RegisterCustomerDTO customer

) {
    
}
