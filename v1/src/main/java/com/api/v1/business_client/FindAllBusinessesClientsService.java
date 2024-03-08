package com.api.v1.business_client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindAllBusinessesClientsService {

    private final BusinessClientRepository repository;

    public ResponseEntity<List<BusinessClient>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
