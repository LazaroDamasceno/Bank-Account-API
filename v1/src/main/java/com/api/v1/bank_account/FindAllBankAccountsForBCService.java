package com.api.v1.bank_account;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.generic_interfaces.FindAll;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindAllBankAccountsForBCService implements FindAll<BankAccountForBC> {

    private final BankAccountForBCRepository repository;

    public ResponseEntity<List<BankAccountForBC>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
