package com.kammatysiak.productsservices.exceptions;

import org.springframework.http.HttpStatus;

public class ProductNullFieldException extends ProductServicesAppException{

    public ProductNullFieldException(String message, HttpStatus status) {
        super(message, status);
    }
}
