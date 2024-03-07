package com.api.v1.bank_account;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
class BankAccount<T> {

    @Id
    private final UUID id = UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.ALL)
    private T user;
    
    private double balance = 0.0;

    BankAccount(T user) {
        this.user = user;
    }

}
