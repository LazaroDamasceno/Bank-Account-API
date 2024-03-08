package com.api.v1.bank_account;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bussiness_client.BussinessClient;
import com.api.v1.bussiness_client.FindBussinessClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindAllBankAcountsService {
    
    private final BankAccountRepository repository;
    private final FindBussinessClientService findBussinessClient;

    public ResponseEntity<List<BankAccount>> findAll(String ein) {
        BussinessClient bussinessClient = findBussinessClient.find(ein);
        return ResponseEntity.ok(
            repository  
                .findAll()
                .stream()
                .filter(e -> e.getBussinessClient().equals(bussinessClient))
                .toList()
        );
    }

}
