package com.api.v1.business_client;

import java.math.BigInteger;
import java.util.UUID;

import com.api.v1.customer.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_business_client")
@Getter
@Setter
@NoArgsConstructor
public class BusinessClient {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private BigInteger ein;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public BusinessClient(RegisterBusinessClientDTO dto) {
        this.ein = new BigInteger(dto.ein());
        this.customer = new Customer(dto.customer());
    }

}