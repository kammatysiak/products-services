package com.kammatysiak.productsservices.mapper;

import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductDto entity);

    ProductDto toProductDto(Product entity);
}
