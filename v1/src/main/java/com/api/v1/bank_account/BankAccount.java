package com.api.v1.bank_account;

import java.util.UUID;

import com.api.v1.business_client.BusinessClient;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v1_bank_account")
@NoArgsConstructor
@Getter
@Setter
class BankAccount {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "business_client_id")
    private BusinessClient businessClient;

    @Column(unique = true)
    private final UUID accountNumber = UUID.randomUUID();

    private double balance = 0.0;

    BankAccount(BusinessClient businessClient) {
        this.businessClient = businessClient;
    }

}
