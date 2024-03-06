package com.api.v1.business_client;

import org.springframework.http.ResponseEntity;

public interface RegisterBusinessClient {

    ResponseEntity<Void> register(RegisterBusinessClientDTO dto);
    
}
