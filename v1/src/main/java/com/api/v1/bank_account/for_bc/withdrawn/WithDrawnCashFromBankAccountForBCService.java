package com.api.v1.bank_account.for_bc.withdrawn;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.bank_account.for_bc.BankAccountForBC;
import com.api.v1.bank_account.for_bc.BankAccountForBCRepository;
import com.api.v1.bank_account.for_bc.FindBankAccountForBCService;
import com.api.v1.exceptions.ForbiddenOperationException;
import com.api.v1.generic_interfaces.WithDrawnCash;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class WithDrawnCastFromBankAccountForBCService implements WithDrawnCash {

    private final BankAccountForBCRepository repository;
    private final FindBankAccountForBCService findBankAccountForBC;

    @Override
    public ResponseEntity<Void> withdrawn(String accountNumber, String ein, double amount) {
        BankAccountForBC bankAccountForBC = findBankAccountForBC.find(accountNumber, ein);
        if (bussinessClientCannotWithdrawn(bankAccountForBC, amount)) {
            throw new ForbiddenOperationException("Not enought cash to withdrawn");
        }
        double newBalance = bankAccountForBC.getBankAccount().getBalance();
        newBalance -= amount;
        bankAccountForBC.getBankAccount().setBalance(newBalance);
        repository.save(bankAccountForBC);
        return ResponseEntity.noContent().build();
    }

    private boolean bussinessClientCannotWithdrawn(BankAccountForBC bankAccountForBC, double amount) {
        return bankAccountForBC.getBankAccount().getBalance() <= 0.0 
            || amount > bankAccountForBC.getBankAccount().getBalance()
            || amount <= 0.0;
    }
    
}
