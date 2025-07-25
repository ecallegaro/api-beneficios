package com.beneficios.domain.exception;

public class BeneficioNotFoundException extends RuntimeException {
    public BeneficioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeneficioNotFoundException(String message) {
        super(message);
    }
}
