package com.api.v1.individual_customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/individuals-customers")
@AllArgsConstructor
class FindIndividualsCustomersController implements FindIndividualsCustomers {

    private final FindIndividualsCustomersService service;

    @Override
    @GetMapping
    public ResponseEntity<List<IndividualCustomer>> findAll() {
        return service.findAll();
    }
    
}
