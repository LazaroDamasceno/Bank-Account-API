package com.api.v1.bank_account.for_bc.deposit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.generic_interfaces.DepositCash;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bank-account-for-bc")
@AllArgsConstructor
public class DepositCashInBankAccoutForBCController implements DepositCash {
    
    private final DepositCashInBankAccoutForBCService service;
    
    @Override
    @PatchMapping("ein/{ein}/accountNumber/{accountNumber}/amount/{amount}")
    public ResponseEntity<Void> deposit(String ein, 
                                        String accountNumber, 
                                        double amount) {
        return service.deposit(ein, accountNumber, amount);
    }
    
}
