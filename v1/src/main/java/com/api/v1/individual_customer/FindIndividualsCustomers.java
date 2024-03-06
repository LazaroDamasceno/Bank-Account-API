package com.api.v1.individual_customer;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface FindIndividualsCustomers {

    ResponseEntity<List<IndividualCustomer>> findAll();
    
}
