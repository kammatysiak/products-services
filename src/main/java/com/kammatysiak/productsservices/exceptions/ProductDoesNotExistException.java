package com.kammatysiak.productsservices.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDoesNotExistException extends ProductServicesAppException {

    public ProductDoesNotExistException(String message, HttpStatus status) {
        super(message, status);
    }

}
