package com.api.v1.bussiness_client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class FindAllBussinessClientsService {

    private final BussinessClientRepository repository;

    public ResponseEntity<List<BussinessClient>> findAll() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }
    
}
