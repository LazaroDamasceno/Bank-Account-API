package com.api.v1.bank_account;

import java.math.BigDecimal;

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

        BankAccount whoTransfer = findBankAccount.find(ein, accountNumber);
        BigDecimal balance = whoTransfer.getBalance();
        balance = balance.subtract(BigDecimal.valueOf(amount));
        whoTransfer.setBalance(balance);
        repository.save(whoTransfer);

        BankAccount whoRecieve = findBankAccount.find(toBankAccount);
        balance = whoRecieve.getBalance();
        balance = balance.add(BigDecimal.valueOf(amount));
        whoRecieve.setBalance(balance);
        repository.save(whoRecieve);

        return ResponseEntity.noContent().build();
    }

}