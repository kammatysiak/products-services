package com.kammatysiak.productsservices.exceptions;

import org.springframework.http.HttpStatus;

public class WrongProductTypeException extends ProductServicesAppException{
    public WrongProductTypeException(String message, HttpStatus status) {
        super(message, status);
    }

}
