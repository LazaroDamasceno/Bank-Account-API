package com.api.v1.bank_account;

import java.util.UUID;

import com.api.v1.business_client.BusinessClient;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v1_bank_account_for_bc")
@NoArgsConstructor
@Getter
@Setter
class BankAccountForBC {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bc_id")
    private BusinessClient businessClient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    public BankAccountForBC(BusinessClient businessClient) {
        this.businessClient = businessClient;
        this.bankAccount = new BankAccount();
    }

}
