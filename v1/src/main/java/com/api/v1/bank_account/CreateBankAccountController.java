package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account")
@AllArgsConstructor
public class CreateBankAccountController {

    private final CreateBankAccountService service;

    @PostMapping("{ein}")
    public ResponseEntity<Void> create(@PathVariable String ein) {
        return service.create(ein);
    }
    
}
