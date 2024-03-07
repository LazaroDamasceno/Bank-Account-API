package com.api.v1.business_client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.generic_interfaces.FindAll;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindAllBusinessesClientsService implements FindAll<BusinessClient> {

    private final BusinessClientRepository repository;

    @Override
    public ResponseEntity<List<BusinessClient>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
