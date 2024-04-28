package com.kammatysiak.productsservices.controller;

import com.kammatysiak.productsservices.model.dto.AssigmentDto;
import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.model.dto.SmartPhoneDto;
import com.kammatysiak.productsservices.model.dto.SmartPhoneSpecificationDto;
import com.kammatysiak.productsservices.service.SmartPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SmartPhoneController {

    private final SmartPhoneService smartPhoneService;

    @PatchMapping("/smartPhone")
    public ProductDto assignProductToSmartphone(@RequestBody AssigmentDto assignmnentDto) {
        return smartPhoneService.assignProductToSmartPhone(assignmnentDto);
    }

    @GetMapping("/smartphone/{id}")
    public SmartPhoneDto getComputerConfigurations(@PathVariable("id") Long id) {
        return smartPhoneService.getSmartPhoneConfigurations(id);
    }

    @GetMapping("/computer")
    public SmartPhoneDto getComputerConfiguration(@PathVariable("id") Long id, @RequestBody SmartPhoneSpecificationDto smartPhoneSpecificationDto) {
        return smartPhoneService.getSmartPhoneConfiguration(id);
    }

}
