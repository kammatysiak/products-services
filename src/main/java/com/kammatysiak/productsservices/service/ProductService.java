package com.kammatysiak.productsservices.service;

import com.kammatysiak.productsservices.exceptions.ProductDoesNotExistException;
import com.kammatysiak.productsservices.exceptions.ProductExistsException;
import com.kammatysiak.productsservices.mapper.ProductMapper;
import com.kammatysiak.productsservices.model.dto.AssigmentDto;
import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.model.entity.Computer;
import com.kammatysiak.productsservices.model.entity.Product;
import com.kammatysiak.productsservices.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kammatysiak.productsservices.model.entity.Product.setProductData;
import static com.kammatysiak.productsservices.validator.ProductValidator.*;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDto)
                .toList();

    }

    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException("Product with given ID does not exist", HttpStatus.NOT_FOUND));
        return productMapper.toProductDto(product);

    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException("Product you are trying to delete does not exist", HttpStatus.NOT_FOUND));
        productRepository.delete(product);
    }

    @Transactional
    public ProductDto updateProduct(Long id, ProductDto newProductData) {
        validateNullsProductDto(newProductData, "Provided product data contains empty fields.");
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException("Product you are trying to change does not exist", HttpStatus.NOT_FOUND));
        isNameAvailable(product.getName(), newProductData.getName());
        setProductData(product, newProductData);
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Transactional
    public ProductDto assignProductToComputer(AssigmentDto assignmentDto) {
            Product computer = productRepository.findById(assignmentDto.getProductAssignorId())
                    .orElseThrow(() -> new ProductDoesNotExistException("The computer you are trying to assign does not exist", HttpStatus.NOT_FOUND));
            checkIfProductisAComputer(computer);
            Product product = productRepository.findById(assignmentDto.getProductAssigneeId())
                    .orElseThrow(() -> new ProductDoesNotExistException("The product you are trying to assign does not exist.", HttpStatus.NOT_FOUND));
            checkIfProductIsComputerAccessory(product);
            product.getPossibleComputers().add(computer);
            productRepository.save(product);
            return productMapper.toProductDto(product);
        }

    private void isNameAvailable(String currentName, String newName) {
        if (!newName.equals(currentName)) {
            if (productRepository.existsByName(newName)) {
                throw new ProductExistsException("Name already exists for " + newName, HttpStatus.CONFLICT);
            }
        }
    }
}
