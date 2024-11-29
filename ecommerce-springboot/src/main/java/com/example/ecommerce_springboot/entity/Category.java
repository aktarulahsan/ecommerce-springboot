package com.example.ecommerce_springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", nullable = false, updatable = false)
    private Long categoryId;

    @Column(name = "CATEGORY_NO", nullable = false)
    private String categoryNo;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "IMAGE_URL", nullable = true)
    private String imageUrl;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;
}

