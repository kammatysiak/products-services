package com.kammatysiak.productsservices.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SMARTPHONES")
@Builder
@Entity
public class SmartPhone extends Product {

    @ManyToOne
    @JoinColumn(name = "COLOUR")
    private String colour;
    @Column(name = "BATTERY")
    private Product battery;
    @Column(name = "ACCESSORIES")
    private List<Product> accessories;


    @ManyToMany
    @JoinTable(
            name = "SMARTPHONE_BATTERIES",
            joinColumns = @JoinColumn(name = "battery_id"),
            inverseJoinColumns = @JoinColumn(name = "smartphone_id"))
    private Set<Product> batteries = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "SMARTPHONE_ACCESORIES",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private Set<Product> smartphoneAccessories = new HashSet<>();
}
