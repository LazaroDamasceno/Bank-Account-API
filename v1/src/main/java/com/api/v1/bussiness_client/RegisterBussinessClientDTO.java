package com.api.v1.bussiness_client;

import com.api.v1.customer.RegisterCustomerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

record RegisterBussinessClientDTO(
    @Pattern(regexp = "[\\d]{9}")
    @NotBlank
    String ein,

    @NotNull
    RegisterCustomerDTO customer
) {
    
}
