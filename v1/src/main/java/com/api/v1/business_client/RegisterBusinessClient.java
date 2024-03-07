package com.api.v1.business_client;

import org.springframework.http.ResponseEntity;

interface RegisterBusinessClient {

    ResponseEntity<Void> register(RegisterBusinessClientDTO dto);
    
}
