package com.beneficios.infrastructure.advice;

import com.beneficios.domain.exception.BeneficioException;
import com.beneficios.domain.exception.BeneficioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class BeneficiosExceptionHandler {
    @ExceptionHandler({BeneficioException.class})
    public ResponseEntity<?> BeneficiosErrors(BeneficioException ex) {
        List<String> errors = new ArrayList<>();

        if (ex.getCause() != null) {
            errors.add(ex.getMessage() + " causa: " + ex.getCause());
        } else {
            errors.add(ex.getMessage());
        }

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BeneficioNotFoundException.class})
    public ResponseEntity<?> BeneficioNotFoundErrors(Exception ex) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
}
