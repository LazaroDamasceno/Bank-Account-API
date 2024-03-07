package com.api.v1.bank_account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.generic_interfaces.Register;
import com.api.v1.business_client.BusinessClient;
import com.api.v1.business_client.FindBusinessClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class RegisterBankAccountForBCService implements Register<String> {

    private final BankAccountForBCRepository repository;
    private final FindBusinessClientService findBusinessClient;

    @Override
    public ResponseEntity<Void> register(String ein) {
        BusinessClient businessClient = findBusinessClient.find(ein);
        BankAccountForBC bankAccountForBC = new BankAccountForBC(businessClient);
        repository.save(bankAccountForBC);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
   
}
