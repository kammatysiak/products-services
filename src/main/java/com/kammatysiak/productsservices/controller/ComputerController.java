package com.kammatysiak.productsservices.controller;

import com.kammatysiak.productsservices.model.dto.AssigmentDto;
import com.kammatysiak.productsservices.model.dto.ComputerDto;
import com.kammatysiak.productsservices.model.dto.ComputerSpecificationDto;
import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computers")
public class ComputerController {

    private final ComputerService computerService;

    @PatchMapping("/computer")
    public ProductDto assignProductToComputer(@RequestBody AssigmentDto assignmentDto) {
        return computerService.assignProductToComputer(assignmentDto);
    }

    @GetMapping("/computer/{id}")
    public ComputerDto getComputerConfigurations(@PathVariable("id") Long id) {
        return computerService.getComputerConfigurations(id);
    }

    @GetMapping("/computer")
    public ComputerDto getComputerConfiguration(@PathVariable("id") Long id, @RequestBody ComputerSpecificationDto computerSpecificationDto) {
        return computerService.getComputerConfiguration(id);
    }

}
