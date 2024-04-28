package com.kammatysiak.productsservices.exceptions;

import org.springframework.http.HttpStatus;

public class ProductExistsException extends ProductServicesAppException{
    public ProductExistsException(String message, HttpStatus status) {
        super(message, status);
    }
}
