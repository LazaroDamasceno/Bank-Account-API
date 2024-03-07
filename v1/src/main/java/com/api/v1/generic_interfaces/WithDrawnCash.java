package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

public interface WithDrawnCash {

    ResponseEntity<Void> withdrawn(String accountNumber, String ein, double amount);
    
}
