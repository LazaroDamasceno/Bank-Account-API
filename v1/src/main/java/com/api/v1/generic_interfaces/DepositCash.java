package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

public interface DepositCash {
    
    ResponseEntity<Void> deposit(String identifier, String accountNumber, double amount);

}
