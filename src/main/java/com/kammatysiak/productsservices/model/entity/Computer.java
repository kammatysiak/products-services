package com.kammatysiak.productsservices.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "COMPUTERS")
@Builder
@Entity
public class Computer extends Product {

    @Column(name = "PROCESSOR")
    private Product processor;
    @Column(name = "RAM")
    private Product ram;
    @Column(name = "HDD")
    private Product hdd;
    @Column(name = "GRAPHICCARD")
    private Product graphiccard;


    @ManyToMany
    @JoinTable(
            name = "COMPUTER_PROCESSOR",
            joinColumns = @JoinColumn(name = "processor_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private Set<Product> processors = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "COMPUTER_RAM",
            joinColumns = @JoinColumn(name = "ram_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private Set<Product> rams = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "COMPUTER_HDD",
            joinColumns = @JoinColumn(name = "hdd_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private Set<Product> hdds = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "COMPUTER_GRAPHICCARD",
            joinColumns = @JoinColumn(name = "graphiccard_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private Set<Product> graphicCards = new HashSet<>();

}
