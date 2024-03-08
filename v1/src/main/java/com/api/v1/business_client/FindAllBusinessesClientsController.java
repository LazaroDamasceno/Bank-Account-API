package com.api.v1.business_client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/bussinesses-clients")
@AllArgsConstructor
class FindAllBusinessesClientsController {

    private final FindAllBusinessesClientsService service;

    @GetMapping
    public ResponseEntity<List<BusinessClient>> findAll() {
        return service.findAll();
    }

}
