package com.api.v1.individual_customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.generic_interfaces.FindAll;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindAllIndividualCustomersService implements FindAll<IndividualCustomer> {

    private final IndividualCustomerRepository repository;

    @Override
    public ResponseEntity<List<IndividualCustomer>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
