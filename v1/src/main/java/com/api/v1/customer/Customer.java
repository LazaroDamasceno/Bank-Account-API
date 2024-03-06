package com.api.v1.customer;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String fullAddress;

    public Customer(RegisterCustomerDTO dto) {
        this.fullName = dto.fullName();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
        this.fullAddress = dto.fullAddress();
    } 

}
