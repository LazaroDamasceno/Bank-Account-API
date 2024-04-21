package com.api.v1.bank_account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bussiness_client.BussinessClient;
import com.api.v1.bussiness_client.FindBussinessClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateBankAccountService {

    private final BankAccountRepository repository;
    private final FindBussinessClientService findBussinessClient;

    public ResponseEntity<Void> create(String ein) {
        BussinessClient bussinessClient = findBussinessClient.find(ein);
        BankAccount bankAccount = new BankAccount(bussinessClient);
        repository.save(bankAccount);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
