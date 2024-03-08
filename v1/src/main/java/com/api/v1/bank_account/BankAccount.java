package com.api.v1.bank_account;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
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

    private BigDecimal balance = BigDecimal.ZERO;

    private final ZonedDateTime creationDate = ZonedDateTime.now();

    BankAccount(BusinessClient businessClient) {
        this.businessClient = businessClient;
    }

}
