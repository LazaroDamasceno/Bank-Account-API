package com.api.v1.individual_customer.register;

import org.springframework.http.ResponseEntity;

public interface RegisterIndividualCustomer {

    ResponseEntity<Void> register(RegisterIndividualCustomerDTO dto);
    
}
