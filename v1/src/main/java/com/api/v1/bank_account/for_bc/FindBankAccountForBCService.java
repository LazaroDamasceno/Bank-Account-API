package com.api.v1.bank_account.for_bc;

import org.springframework.stereotype.Service;

import com.api.v1.bank_account.BankAccount;
import com.api.v1.bank_account.FindBankAccountService;
import com.api.v1.business_client.BusinessClient;
import com.api.v1.business_client.FindBusinessClientService;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindBankAccountForBCService {

    private final BankAccountForBCRepository repository;
    private final FindBankAccountService findBankAccount;
    private final FindBusinessClientService findBusinessClient;

    public BankAccountForBC find(String accountNumber, String ein) {
        BusinessClient businessClient = findBusinessClient.find(ein);
        BankAccount bankAccount = findBankAccount.find(accountNumber);
        if (bussinessClientNotOwnsAccount(bankAccount, businessClient)) {
            throw new ForbiddenOperationException("");
        }
        return  repository.findByBankAccount(bankAccount);
    }

    private boolean bussinessClientNotOwnsAccount(BankAccount bankAccount, BusinessClient businessClient) {
        return !repository.findByBankAccount(bankAccount).getBusinessClient().equals(businessClient);
    }
    
}
