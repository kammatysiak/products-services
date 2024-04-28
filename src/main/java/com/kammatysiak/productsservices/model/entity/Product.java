package com.kammatysiak.productsservices.model.entity;

import com.kammatysiak.productsservices.model.dto.ProductDto;
import com.kammatysiak.productsservices.model.enumeration.Subtype;
import com.kammatysiak.productsservices.model.enumeration.Type;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PRODUCTS")
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "TYPE")
    private Type type;
    @Column(name = "SUBTYPE")
    private Subtype subtype;
    @ManyToMany(mappedBy = "computers")
    private Set<Computer> possibleComputers = new HashSet<>();
    @ManyToMany(mappedBy = "smartphone")
    private Set<SmartPhone> possibleSmartphones = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "SMARTPHONE_BATTERIES",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "smartphone_id"))
    private Set<Product> batteries = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "SMARTPHONE_ACCESORIES",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private Set<Product> smartphoneAccessories = new HashSet<>();

    public static void setProductData(Product product, ProductDto newProductData) {
        product.setName(newProductData.getName());
        product.setPrice(newProductData.getPrice());
        product.setType(newProductData.getType());
        product.setSubtype(newProductData.getSubtype());
    }

}
