package com.entrega_2.luking.expedition;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private String mensaje;
    private String codigo;
    private LocalDateTime timestamp;
}
