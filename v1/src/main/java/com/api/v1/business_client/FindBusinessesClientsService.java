package com.api.v1.business_client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindBusinessesClientsService implements FindBusinessesClients {

    private final BusinessClientRepository repository;

    @Override
    public ResponseEntity<List<BusinessClient>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
