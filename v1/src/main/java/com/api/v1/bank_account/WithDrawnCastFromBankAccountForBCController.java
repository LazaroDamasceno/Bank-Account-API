package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.generic_interfaces.WithDrawnCash;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/vq/bank-account-for-bc")
@AllArgsConstructor
class WithDrawnCastFromBankAccountForBCController implements WithDrawnCash {
    
    private final WithDrawnCastFromBankAccountForBCService service;
    
    @Override
    @PatchMapping("ein/{ein}/accountNumber/{accountNumber}/amount/{amount}")
    public ResponseEntity<Void> withdrawn(@PathVariable String accountNumber, 
                                          @PathVariable String ein, 
                                          @PathVariable double amount) {
        return service.withdrawn(accountNumber, ein, amount);
    }

}
