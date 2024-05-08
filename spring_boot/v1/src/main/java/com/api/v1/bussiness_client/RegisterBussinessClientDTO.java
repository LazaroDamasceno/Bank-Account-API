package com.api.v1.bussiness_client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

record RegisterBussinessClientDTO(
    @Pattern(regexp = "[\\d]{9}")
    @NotBlank
    String ein,

    @NotBlank
    String fullName,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "[\\d]{10}")
    String phoneNumber,

    @NotBlank
    String fullAddress
) {
    
}
