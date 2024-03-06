package com.api.v1.individual_customer.register;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.customer.Customer;
import com.api.v1.dtos.DateDTO;
import com.api.v1.exception.ForbiddenOperation;
import com.api.v1.individual_customer.IndividualCustomer;
import com.api.v1.individual_customer.IndividualCustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterIndividualCustomerService implements RegisterIndividualCustomer {

    private final IndividualCustomerRepository repository;

    @Override
    public ResponseEntity<Void> register(RegisterIndividualCustomerDTO dto) {
        Optional<IndividualCustomer> optional = repository.findBySsn(new BigInteger(dto.ssn()));
        if (optional.isPresent()) throw new ForbiddenOperation("Individual customer already exist.");
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setBirthDay(new DateDTO(dto.birthDay()).get());
        individualCustomer.setSsn(new BigInteger(dto.ssn()));
        individualCustomer.setCustomer(new Customer(dto.customer()));
        repository.save(individualCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
