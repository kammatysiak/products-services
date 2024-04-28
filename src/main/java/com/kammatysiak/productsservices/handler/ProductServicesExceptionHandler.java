package com.kammatysiak.productsservices.handler;

import com.kammatysiak.productsservices.exceptions.ProductDoesNotExistException;
import com.kammatysiak.productsservices.exceptions.ProductExistsException;
import com.kammatysiak.productsservices.exceptions.ProductNullFieldException;
import com.kammatysiak.productsservices.model.dto.ExceptionMessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class ProductServicesExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductDoesNotExistException.class})
    public ResponseEntity<ExceptionMessageDto> handleProductDoesNotExistException(ProductDoesNotExistException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ExceptionMessageDto(ex.getMessage(), LocalDateTime.now(), ex.getStatus()));
    }
    @ExceptionHandler({ProductExistsException.class})
    public ResponseEntity<ExceptionMessageDto> handleProductExistsException(ProductExistsException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ExceptionMessageDto(ex.getMessage(), LocalDateTime.now(), ex.getStatus()));
    }
    @ExceptionHandler({ProductNullFieldException.class})
    public ResponseEntity<ExceptionMessageDto> handleProductNullFieldException(ProductNullFieldException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ExceptionMessageDto(ex.getMessage(), LocalDateTime.now(), ex.getStatus()));
    }

}
