package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.exceptions.ForbiddenOperationException;
import com.api.v1.generic_interfaces.DepositCash;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class DepositCashInBankAccoutForBCService implements DepositCash {

    private final BankAccountForBCRepository repository;
    private final FindBankAccountForBCService findBankAccountForBC;

    @Override
    public ResponseEntity<Void> deposit(String ein, String accountNumber, double amount) {
        if (amount <= 0.0) {
            throw new ForbiddenOperationException("The amount to be deposited must more than 0.0");
        }
        BankAccountForBC bankAccountForBC = findBankAccountForBC.find(accountNumber, ein);
        double newBalance = bankAccountForBC.getBankAccount().getBalance();
        newBalance += amount;
        bankAccountForBC.getBankAccount().setBalance(newBalance);
        repository.save(bankAccountForBC);
        return ResponseEntity.noContent().build();
    }
    
}
