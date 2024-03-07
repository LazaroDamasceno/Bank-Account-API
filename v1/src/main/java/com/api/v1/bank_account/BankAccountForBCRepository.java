package com.api.v1.bank_account;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface BankAccountForBCRepository extends JpaRepository<BankAccountForBC, UUID> {

    @Query("""
        select bk from BankAccountForBC bk
        where bk.bankAccount = :bankAccount
    """)
    BankAccountForBC findByBankAccount(@Param("bankAccount") BankAccount bankAccount);
    
}
