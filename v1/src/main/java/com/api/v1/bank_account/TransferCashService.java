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
    
    public ResponseEntity<Void> transfer(String ein, String accountNumber, String otherBankAccount, double amount) {
        if (amount <= Constants.ZEROED_BALANCE) {
            throw new ForbiddenOperationException("The amount cannot be less or equals to zero.");
        }
        BankAccount bankAccount1 = findBankAccount.find(ein, accountNumber);
        int comparedBigDecimals = BigDecimal.valueOf(amount).compareTo(bankAccount1.getBalance());
        if (comparedBigDecimals >= 1) {
            throw new ForbiddenOperationException("Not enought balance to withdraw.");
        }
        BigDecimal balance1 = bankAccount1.getBalance();
        balance1 = balance1.subtract(BigDecimal.valueOf(amount));
        bankAccount1.setBalance(balance1);
        repository.save(bankAccount1);
        Optional<BankAccount> optional = repository.findByAccountNumber(UUID.fromString(otherBankAccount));
        if (optional.isEmpty()) {
            throw new ForbiddenOperationException("Bank account does not exist.");
        }
        BankAccount bankAccount2 = optional.get();
        BigDecimal balance2 = bankAccount2.getBalance();
        balance2 = balance2.add(BigDecimal.valueOf(amount));
        bankAccount2.setBalance(balance2);
        repository.save(bankAccount2);
        return ResponseEntity.noContent().build();
    }

}
