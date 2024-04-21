package com.api.v1.bank_account;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.Constants;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WithdrawCashService {
    
    private final BankAccountRepository repository;
    private final FindBankAccountService findBankAccount;

    public ResponseEntity<Void> withdraw(String ein, String accountNumber, double amount) {
        if (amount <= Constants.ZEROED_BALANCE) {
            throw new ForbiddenOperationException("The amount cannot be less or equals to zero.");
        }
        BankAccount bankAccount = findBankAccount.find(ein, accountNumber);
        int comparedBigDecimals = BigDecimal.valueOf(amount).compareTo(bankAccount.getBalance());
        if (comparedBigDecimals >= 1) {
            throw new ForbiddenOperationException("Not enought balance to withdraw.");
        }
        BigDecimal balance = bankAccount.getBalance();
        balance = balance.subtract(BigDecimal.valueOf(amount));
        bankAccount.setBalance(balance);
        repository.save(bankAccount);
        return ResponseEntity.noContent().build();
    }

}
