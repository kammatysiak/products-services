package com.kammatysiak.productsservices.validator;

import com.kammatysiak.productsservices.exceptions.ProductNullFieldException;
import com.kammatysiak.productsservices.exceptions.WrongProductTypeException;
import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.model.entity.Product;
import com.kammatysiak.productsservices.model.enumeration.Subtype;
import com.kammatysiak.productsservices.model.enumeration.Type;
import org.springframework.http.HttpStatus;

import java.util.Objects;
import java.util.stream.Stream;

public final class ProductValidator {

    public static void validateNullsProductDto(ProductDto productDto, String message) {
        if (Stream.of(productDto.getType(), productDto.getSubtype(), productDto.getPrice(), productDto.getName())
                .anyMatch(Objects::isNull)) {
            throw new ProductNullFieldException(message, HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkIfProductisAComputer(Product product, String message){
        if (!product.getType().equals(Type.COMPUTER)){
            throw new WrongProductTypeException(message, HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkIfProductIsComputerAccessory(Product product, String message){
        if (){
            throw new WrongProductTypeException(message, HttpStatus.BAD_REQUEST);
        }
    }
}
