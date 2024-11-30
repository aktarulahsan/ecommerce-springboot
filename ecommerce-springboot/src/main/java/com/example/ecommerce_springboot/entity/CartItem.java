package com.example.ecommerce_springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID", nullable = false)
    private Long cartId;

    @OneToMany(mappedBy = "cartItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartDetails> cartDetails;

    @Column(name = "ITEM_COUNT", nullable = false)
    private int itemCount;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice;

}
