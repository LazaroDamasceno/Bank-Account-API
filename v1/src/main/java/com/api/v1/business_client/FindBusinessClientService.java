package com.api.v1.business_client;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.dtos.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindBusinessClientService {

    private final BusinessClientRepository repository;

    public BusinessClient find(String ein) {
        Optional<BusinessClient> optional = repository.findByEin(ein);
        if (optional.isEmpty()) throw new ForbiddenOperationException("Business client does not exist.");
        return optional.get();
    }
    
}
