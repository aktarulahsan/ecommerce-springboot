package com.example.ecommerce_springboot.entity;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name = "cart_details")
public class CartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_DETAILS_ID")
    private Long cartDetailsId;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private CartItem cartItem;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "SUBTOTAL")
    private double subtotal;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "RATING")
    private double rating;

    // getters and setters (Lombok @Data provides these)
}
