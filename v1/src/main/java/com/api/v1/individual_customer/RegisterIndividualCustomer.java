package com.api.v1.individual_customer;

import org.springframework.http.ResponseEntity;

interface RegisterIndividualCustomer {

    ResponseEntity<Void> register(RegisterIndividualCustomerDTO dto);
    
}
