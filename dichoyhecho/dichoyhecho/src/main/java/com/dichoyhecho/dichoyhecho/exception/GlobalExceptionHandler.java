package com.dichoyhecho.dichoyhecho.exception;

import jakarta.validation.ConstraintDeclarationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleValidation(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Message", ex.getMessage()));
    }

    @ExceptionHandler(ConstraintDeclarationException.class)
    public ResponseEntity<?> handleValidation(ConstraintViolationException ex){
        String msg = ex
                .getConstraintViolations().iterator().next().getMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST).body(Map.of("Message", msg));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleBodyValidation(MethodArgumentNotValidException ex){
        List<String> message = ex
                .getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage()).toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST).body(Map.of("message", message));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleBadJson(HttpMessageNotReadableException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "La estructura es incorrecta"));

    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", ex.getMessage() ));
    }

}
