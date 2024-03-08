package com.api.v1.bussiness_client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bussiness-client")
@AllArgsConstructor
class RegisterBussinessClientController {
    
    private final RegisterBussinessClientService service;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterBussinessClientDTO dto) {
        return service.register(dto);
    }

}
