package com.api.v1.bank_account;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.Constants;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferCashService {

    private final BankAccountRepository repository;
    private final FindBankAccountService findBankAccount;
    
    public ResponseEntity<Void> transfer(String ein, String accountNumber, String toBankAccount, double amount) {
        if (amount <= Constants.ZEROED_BALANCE) {
            throw new ForbiddenOperationException("The amount cannot be less or equals to zero.");
        }

        //return ResponseEntity.noContent().build();
    }

}
