package com.rishi.product.Exception;

import com.rishi.product.DTO.GlobalExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice               // or @ControllerAdvice if you are returning views
public class GlobalExceptionHandle {

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<GlobalExceptionDTO> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException ex, WebRequest webRequest){
        GlobalExceptionDTO globalExceptionDTO = new GlobalExceptionDTO(
                ex.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(globalExceptionDTO);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<GlobalExceptionDTO> handleCategoryNotFoundException(CategoryNotFoundException ex, WebRequest webRequest){
        GlobalExceptionDTO globalExceptionDTO = new GlobalExceptionDTO(
                ex.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(globalExceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalExceptionDTO> handleGlobalException(Exception ex, WebRequest webRequest){
        GlobalExceptionDTO globalExceptionDTO = new GlobalExceptionDTO(
                ex.getMessage(),
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(globalExceptionDTO);
    }
}
