package com.api.v1.business_client;

import java.util.List;

import org.springframework.http.ResponseEntity;

interface FindBusinessesClients {
    
    ResponseEntity<List<BusinessClient>> findAll();

}
