package com.api.v1.bank_account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.bussiness_client.BussinessClient;

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

    @Column(unique = true)
    private final UUID accountNumber = UUID.randomUUID();

    private BigDecimal balance = BigDecimal.ZERO.setScale(2);

    private final LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Bussiness_client_id")
    private BussinessClient bussinessClient;

    BankAccount(BussinessClient bussinessClient) {
        this.bussinessClient = bussinessClient;
    }

}
