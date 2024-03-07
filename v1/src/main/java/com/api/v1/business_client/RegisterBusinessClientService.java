package com.api.v1.business_client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.generic_interfaces.Register;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class RegisterBusinessClientService implements Register<RegisterBusinessClientDTO> {

    private final BusinessClientRepository repository;

    @Override
    public ResponseEntity<Void> register(RegisterBusinessClientDTO dto) {
        BusinessClient businessClient = new BusinessClient(dto);
        repository.save(businessClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
