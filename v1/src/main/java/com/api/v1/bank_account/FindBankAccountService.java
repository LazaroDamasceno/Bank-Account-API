package com.api.v1.bank_account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.v1.bussiness_client.BussinessClient;
import com.api.v1.bussiness_client.FindBussinessClientService;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindBankAccountService {

    private final BankAccountRepository repository;
    private final FindBussinessClientService findBussinessClient;

    public BankAccount find(String ein, String accountNumber) {
        BussinessClient bussinessClient = findBussinessClient.find(ein);
        UUID bankAccountNumber = UUID.fromString(accountNumber);
        Optional<BankAccount> optional = repository.findByAccountNumber(bankAccountNumber);
        if (optional.isEmpty()) {
            throw new ForbiddenOperationException("Bank account does not exist.");
        }
        if (!optional.get().getBussinessClient().equals(bussinessClient)) {
            throw new ForbiddenOperationException("Bank account does not belong to the bussiness client.");
        }
        return optional.get();
    }

    public BankAccount find(String accountNumber) {
        Optional<BankAccount> optional = repository.findByAccountNumber(UUID.fromString(accountNumber));
        if (optional.isEmpty()) {
            throw new ForbiddenOperationException("Bank account does not exist.");
        }
        return optional.get();
    }
    
}
