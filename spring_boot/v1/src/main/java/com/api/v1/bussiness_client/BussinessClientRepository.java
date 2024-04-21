package com.api.v1.bussiness_client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface BussinessClientRepository extends JpaRepository<BussinessClient, UUID> {

    Optional<BussinessClient> findByEin(String ein);
    
}
