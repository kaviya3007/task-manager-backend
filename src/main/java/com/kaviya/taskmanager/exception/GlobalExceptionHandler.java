package com.kaviya.taskmanager.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpServletRequest request) {

        String allowed = ex.getSupportedHttpMethods() == null
                ? ""
                : ex.getSupportedHttpMethods().stream()
                .map(org.springframework.http.HttpMethod::name)
                .collect(Collectors.joining(", "));

        Map<String, Object> body = Map.of(
                "timestamp", OffsetDateTime.now().toString(),
                "status", HttpStatus.METHOD_NOT_ALLOWED.value(),
                "error", "Method Not Allowed",
                "message", "Use one of the allowed methods for this endpoint.",
                "allowedMethods", allowed,
                "path", request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(body);
    }
}
