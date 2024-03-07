package com.api.v1.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.Pattern;

public record DateDTO(
    @Pattern(regexp = "[\\d]{2}/[\\d]{2}/[\\d]{4}") 
    String date
) {
    
    public LocalDate get() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dtf);
    }

}