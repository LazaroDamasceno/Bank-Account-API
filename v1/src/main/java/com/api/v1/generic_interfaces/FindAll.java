package com.api.v1.generic_interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface FindAll<T> {

    ResponseEntity<List<T>> findAll();
    
}
