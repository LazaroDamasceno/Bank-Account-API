package com.api.v1.bank_account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.v1.business_client.BusinessClient;
import com.api.v1.business_client.FindBusinessClientService;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindBankAccountService {

    private final BankAccountRepository repository;
    private final FindBusinessClientService findBusinessClient;

    public BankAccount find(String ein, String accountNumber) {
        BusinessClient businessClient = findBusinessClient.find(ein);
        UUID bankAccountNumber = UUID.fromString(accountNumber);
        Optional<BankAccount> optional = repository.findByAccountNumber(bankAccountNumber);
        if (optional.isEmpty()) {
            throw new ForbiddenOperationException("Bank account does not exist.");
        }
        if (optional.get().getBusinessClient().equals(businessClient)) {
            throw new ForbiddenOperationException("Bank account does not belong to the bussiness client.");
        }
        return optional.get();
    }
    
}
