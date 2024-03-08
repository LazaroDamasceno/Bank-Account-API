package com.api.v1.bussiness_client;

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
@Table(name = "v1_Bussiness_client")
@Getter
@Setter
@NoArgsConstructor
public class BussinessClient {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private String ein;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    BussinessClient(RegisterBussinessClientDTO dto) {
        this.ein = dto.ein();
        this.customer = new Customer(dto.customer());
    }

}