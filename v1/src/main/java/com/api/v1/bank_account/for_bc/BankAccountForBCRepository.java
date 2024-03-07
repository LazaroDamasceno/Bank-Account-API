package com.api.v1.bank_account.for_bc;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.v1.bank_account.BankAccount;

public interface BankAccountForBCRepository extends JpaRepository<BankAccountForBC, UUID> {

    @Query("""
        select bk from BankAccoutForBC bk
        bk.bankAccount = :bankAccount
    """)
    BankAccountForBC findByBankAccount(@Param("bankAccount") BankAccount bankAccount);
    
}
