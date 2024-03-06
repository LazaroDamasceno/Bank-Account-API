package com.api.v1.individual_customer.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.individual_customer.IndividualCustomer;
import com.api.v1.individual_customer.IndividualCustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindIndividualsCustomersService implements FindIndividualsCustomers {

    private final IndividualCustomerRepository repository;

    @Override
    public ResponseEntity<List<IndividualCustomer>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
