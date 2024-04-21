package com.api.v1.bank_account;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-accounts")
@AllArgsConstructor
public class FindAllBankAccountsController {

    private final FindAllBankAccountsService service;

    @GetMapping("{ein}")
    public ResponseEntity<List<BankAccount>> findAll(@PathVariable String ein) {
        return service.findAll(ein);
    }
    
}
