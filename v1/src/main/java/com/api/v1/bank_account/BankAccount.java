package com.api.v1.bank_account;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v1_bank_account")
@NoArgsConstructor
@Getter
@Setter
public class BankAccount {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @Column(unique = true)
    private final UUID accountNumber = UUID.randomUUID();

    private double balance = 0.0;

}
