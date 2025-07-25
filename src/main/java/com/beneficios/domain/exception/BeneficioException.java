package com.beneficios.domain.exception;

public class BeneficioException extends RuntimeException {
    public BeneficioException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeneficioException(String message) {
        super(message);
    }
}
