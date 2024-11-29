package com.example.ecommerce_springboot.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false, updatable = false)
    private Long productId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "IMAGE", nullable = false)
    private String image;

    @Column(name = "RATING")
    private double rating;


}
