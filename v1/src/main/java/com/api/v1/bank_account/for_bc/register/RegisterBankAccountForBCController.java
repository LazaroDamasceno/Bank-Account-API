package com.api.v1.bank_account.for_bc.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.generic_interfaces.Register;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account-for-bc")
@AllArgsConstructor
public class RegisterBankAccountForBCController implements Register<String> {
    
    private final RegisterBankAccountForBCService service;

    @Override
    @PostMapping("{ein}")
    public ResponseEntity<Void> register(@PathVariable String ein) {
        return service.register(ein);
    }

}
