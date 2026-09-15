package org.example.eventservice.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrganizerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOrganizerNotFound(OrganizerNotFoundException ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("status", 404);
        error.put("message", ex.getMessage());
        error.put("error", "Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Map<String, Object>> handleFeignNotFound(FeignException.NotFound ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("status", 404);
        error.put("message", "OrganizerId khong ton tai");
        error.put("error", "Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("status", 500);
        error.put("message", ex.getMessage());
        error.put("error", "Internal Server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
