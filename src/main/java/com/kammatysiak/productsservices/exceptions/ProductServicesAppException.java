package com.kammatysiak.productsservices.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductServicesAppException extends RuntimeException {

    private final HttpStatus status;

    public ProductServicesAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
