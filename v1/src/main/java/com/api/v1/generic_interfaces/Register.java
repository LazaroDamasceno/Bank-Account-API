package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

public interface Register<T> {

    ResponseEntity<Void> register(T input);
    
}
