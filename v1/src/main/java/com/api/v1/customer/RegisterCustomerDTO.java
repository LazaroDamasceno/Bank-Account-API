package com.api.v1.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterCustomerDTO(
    @NotBlank
    String fullName,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "[\\d]{10}")
    String phoneNumber,

    String fullAddress
) {
    
}
