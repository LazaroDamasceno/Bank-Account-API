package com.api.v1.bank_account;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.generic_interfaces.DeleteBankAccount;
import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class DeleteBankAccoutForBCService implements DeleteBankAccount {

    private final BankAccountForBCRepository repository;
    private final FindBankAccountForBCService findBankAccountForBC;

    @Override
    public ResponseEntity<Void> delete(String accountNumber, String ein) {
        BankAccountForBC bankAccountForBC = findBankAccountForBC.find(accountNumber, ein);
        if (isBussinessClientInDebt(bankAccountForBC)) 
            throw new ForbiddenOperationException("Bank account cannot be deleted due to existind debts.");
        repository.delete(bankAccountForBC);
        return ResponseEntity.noContent().build();
    }

    private boolean isBussinessClientInDebt(BankAccountForBC bankAccountForBC) {
        return bankAccountForBC.getBankAccount().getBalance() < 0.0;
    }
    
}
