package com.api.v1.individual_customer.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.individual_customer.IndividualCustomer;

public interface FindIndividualsCustomers {

    ResponseEntity<List<IndividualCustomer>> findAll();
    
}
