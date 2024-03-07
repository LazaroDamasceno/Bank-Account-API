package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.generic_interfaces.DeleteBankAccount;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account-for-bc")
@AllArgsConstructor
class DeleteBankAccoutForBCController implements DeleteBankAccount {
    
    private final DeleteBankAccoutForBCService service;
    
    @Override
    @DeleteMapping("ein/{ein}/accountNumber/{accountNumber}")
    public ResponseEntity<Void> delete(@PathVariable String accountNumber, @PathVariable String ein) {
        return service.delete(accountNumber, ein);
    }
    
}
