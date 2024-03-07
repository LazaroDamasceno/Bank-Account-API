package com.api.v1.bank_account.for_bc.all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.bank_account.for_bc.BankAccountForBC;
import com.api.v1.generic_interfaces.FindAll;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-accounts-for-bc")
@AllArgsConstructor
class FindAllBankAccountsForBCController implements FindAll<BankAccountForBC> {

    private final FindAllBankAcoountsForBCService service;

    @Override
    @GetMapping
    public ResponseEntity<List<BankAccountForBC>> findAll() {
        return service.findAll();
    }
    
}
