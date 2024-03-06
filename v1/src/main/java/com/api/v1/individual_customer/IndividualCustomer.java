package com.api.v1.individual_customer;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

import com.api.v1.customer.Customer;
import com.api.v1.dtos.DateDTO;
import com.api.v1.individual_customer.register.RegisterIndividualCustomerDTO;

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
@Table(name = "v1_client")
@Getter
@Setter
@NoArgsConstructor
public class IndividualCustomer {
    
    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private LocalDate birthDay;

    @Column(nullable = false, unique = true)
    private BigInteger ssn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public IndividualCustomer(RegisterIndividualCustomerDTO dto) {
        this.birthDay = new DateDTO(dto.birthDay()).get();
        this.ssn = new BigInteger(dto.ssn());
        this.customer = new Customer(dto.customer());
    }
    
}
