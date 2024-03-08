package com.api.v1.bussiness_client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class RegisterBussinessClientService {

    private final BussinessClientRepository repository;

    public ResponseEntity<Void> register(RegisterBussinessClientDTO dto) {
        BussinessClient bussinessClient = new BussinessClient(dto);
        repository.save(bussinessClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
