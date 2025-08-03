package com.rishi.product.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GlobalExceptionDTO {

    private String errorMessage;
    private String apiPath;
    private HttpStatus httpStatusCode;
    private LocalDateTime errorTime;
}
