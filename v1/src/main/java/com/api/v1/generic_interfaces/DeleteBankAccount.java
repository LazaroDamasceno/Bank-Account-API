package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

public interface DeleteBankAccount {

    ResponseEntity<Void> delete(String accountNumber, String identifier);
    
}
