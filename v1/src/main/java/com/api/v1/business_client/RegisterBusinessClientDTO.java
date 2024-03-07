package com.api.v1.business_client;

import com.api.v1.customer.RegisterCustomerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

record RegisterBusinessClientDTO(
    @Pattern(regexp = "[\\d]{9}")
    @NotBlank
    String ein,

    @NotNull
    RegisterCustomerDTO customer
) {
    
}
