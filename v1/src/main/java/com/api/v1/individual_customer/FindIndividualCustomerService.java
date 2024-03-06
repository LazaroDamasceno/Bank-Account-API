package com.api.v1.individual_customer;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.exception.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindIndividualCustomerService {
      
    private final IndividualCustomerRepository repository;
    
    public IndividualCustomer find(String ssn) {
        Optional<IndividualCustomer> optional =  repository.findBySsn(new BigInteger(ssn));
        if (optional.isEmpty()) throw new ForbiddenOperationException("Individual customer does not exist.");
        return optional.get();
    }
    
}
