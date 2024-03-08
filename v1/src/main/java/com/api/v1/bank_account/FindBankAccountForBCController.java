package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account-for-bc")
@AllArgsConstructor
public class FindBankAccountForBCController {

    private final FindBankAccountForBCService service;

    @GetMapping("ein/{ein}/accountNumber/{accountNumber}")
    public ResponseEntity<BankAccountForBC> find(@PathVariable String accountNumber, @PathVariable String ein) {
        return ResponseEntity.ok(
            service.find(accountNumber, ein)
        );
    }
    
}
