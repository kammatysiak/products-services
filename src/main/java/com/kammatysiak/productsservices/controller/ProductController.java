package com.kammatysiak.productsservices.controller;

import com.kammatysiak.productsservices.model.dto.AssigmentDto;
import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto newProductData) {
        return productService.updateProduct(id, newProductData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @PatchMapping("/computer")
    public ProductDto assignProductToComputerSpecification(@RequestBody AssigmentDto assignmentDto) {
        return productService.assignProductToComputerSpecification(assignmentDto);
    }
    @PatchMapping("/computer")
    public ProductDto assignProductToSmartPhoneSpecification(@RequestBody AssigmentDto assignmentDto) {
        return productService.assignProductToSmartphoneSpecification(assignmentDto);
    }
}
