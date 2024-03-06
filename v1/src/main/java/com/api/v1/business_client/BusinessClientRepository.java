package com.api.v1.business_client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

public interface BusinessClientRepository extends JpaRepository<BusinessClient, UUID> {

    Optional<BusinessClient> findByEin(BigInteger ein);
    
}
