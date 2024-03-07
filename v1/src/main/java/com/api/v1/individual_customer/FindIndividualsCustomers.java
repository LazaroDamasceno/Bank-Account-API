package com.api.v1.individual_customer;

import java.util.List;

import org.springframework.http.ResponseEntity;

interface FindIndividualsCustomers {

    ResponseEntity<List<IndividualCustomer>> findAll();
    
}
