package com.kammatysiak.productsservices.model.dto;

import com.kammatysiak.productsservices.model.enumeration.Subtype;
import com.kammatysiak.productsservices.model.enumeration.Type;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ProductDto {

    private String name;
    private BigDecimal price;
    private Type type;
    private Subtype subtype;
    private List<Long> computerIds;
    private List<Long> SmartphoneIds;

}
