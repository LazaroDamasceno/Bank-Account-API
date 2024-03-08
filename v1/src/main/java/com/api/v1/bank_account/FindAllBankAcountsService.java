package com.api.v1.bank_account;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.business_client.BusinessClient;
import com.api.v1.business_client.FindBusinessClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindAllBankAcountsService {
    
    private final BankAccountRepository repository;
    private final FindBusinessClientService findBusinessClient;

    public ResponseEntity<List<BankAccount>> findAll(String ein) {
        BusinessClient businessClient = findBusinessClient.find(ein);
        return ResponseEntity.ok(
            repository  
                .findAll()
                .stream()
                .filter(e -> e.getBusinessClient().equals(businessClient))
                .toList()
        );
    }

}
