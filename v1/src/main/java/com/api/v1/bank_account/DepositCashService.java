package com.api.v1.bank_account;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.Constants;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepositCashService {

    private final BankAccountRepository repository;
    private final FindBankAccountService findBankAccount;

    public ResponseEntity<Void> deposit(String ein, String accountNumber, double amount) {
        if (amount <= Constants.ZEROED_BALANCE) {
            throw new ForbiddenOperationException("The amount cannot be less or equals to zero.");
        }
        BankAccount bankAccount = findBankAccount.find(ein, accountNumber);
        BigDecimal balance = bankAccount.getBalance();
        balance = balance.add(BigDecimal.valueOf(amount));
        bankAccount.setBalance(balance);
        repository.save(bankAccount);
        return ResponseEntity.noContent().build();
    }
    
}
