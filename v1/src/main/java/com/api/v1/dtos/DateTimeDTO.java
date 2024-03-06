package com.api.v1.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.Pattern;

public record DateTimeDTO(
    @Pattern(regexp = "[\\d]{2}/[\\d]{2}/[\\d]{4} [\\d]{2}:[\\d]{2}:[\\d]{2}") String dateTime)
{
    
    public LocalDateTime get() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, dtf);
    }

}
