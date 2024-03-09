package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account")
@AllArgsConstructor
public class TransferCashController {

    private final TransferCashService service;

    @PatchMapping("ein/{ein}/accountNumber/{accountNumber}/otherBankAccount/{otherBankAccount}/amount/{amount}")
    public ResponseEntity<Void> transfer(@PathVariable String ein, 
                                         @PathVariable String accountNumber, 
                                         @PathVariable String otherBankAccount, 
                                         @PathVariable double amount) {
        return service.transfer(ein, accountNumber, otherBankAccount, amount);
    }
    
}
