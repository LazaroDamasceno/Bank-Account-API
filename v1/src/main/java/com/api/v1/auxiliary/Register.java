package com.api.v1.auxiliary;

import org.springframework.http.ResponseEntity;

public interface Register<T> {

    ResponseEntity<Void> register(T input);
    
}
