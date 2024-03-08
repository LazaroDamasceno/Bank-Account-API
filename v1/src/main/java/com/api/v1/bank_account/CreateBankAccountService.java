package com.api.v1.bank_account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.business_client.BusinessClient;
import com.api.v1.business_client.FindBusinessClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateBankAccountService {

    private final BankAccountRepository repository;
    private final FindBusinessClientService findBusinessClient;

    public ResponseEntity<Void> create(String ein) {
        BusinessClient businessClient = findBusinessClient.find(ein);
        BankAccount bankAccount = new BankAccount(businessClient);
        repository.save(bankAccount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
