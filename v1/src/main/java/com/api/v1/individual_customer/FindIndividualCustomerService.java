package com.api.v1.individual_customer;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindIndividualCustomerService {
      
    private final IndividualCustomerRepository repository;
    
    public IndividualCustomer find(String ssn) {
        Optional<IndividualCustomer> optional =  repository.findBySsn(ssn);
        if (optional.isEmpty()) throw new ForbiddenOperationException("Individual customer does not exist.");
        return optional.get();
    }
    
}
