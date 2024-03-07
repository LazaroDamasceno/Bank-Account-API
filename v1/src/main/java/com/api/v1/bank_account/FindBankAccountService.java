package com.api.v1.bank_account;

import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindBankAccountService {

    private final BankAccountRepository repository;

    public BankAccount find(String accountNumber) {
        UUID number = UUID.fromString(accountNumber);
        Optional<BankAccount> optional = repository.findByAccountNumber(number);
        if (optional.isEmpty()) throw new ForbiddenOperationException("Bank account does not exist.");
        return optional.get();
    }
    
}
