package com.api.v1.bank_account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-accounts")
@AllArgsConstructor
public class FindBankAccountController {

    private final FindBankAccountService service;

    @GetMapping("ein/{ein}/accountNumber/{accountNumber}")
    public BankAccount find(@PathVariable String ein, @PathVariable final String accountNumber) {
        return service.find(ein, accountNumber);
    }
    
}
