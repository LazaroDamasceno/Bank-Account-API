package com.api.v1.bussiness_client;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.exceptions.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindBussinessClientService {

    private final BussinessClientRepository repository;

    public BussinessClient find(String ein) {
        Optional<BussinessClient> optional = repository.findByEin(ein);
        if (optional.isEmpty()) throw new ForbiddenOperationException("Bussiness client does not exist.");
        return optional.get();
    }
    
}
