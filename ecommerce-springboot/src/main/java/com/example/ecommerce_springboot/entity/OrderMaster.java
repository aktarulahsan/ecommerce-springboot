package com.example.ecommerce_springboot.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order_master")
public class OrderMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false, updatable = false)
    private Long orderId;

    @Column(name = "ORDER_NO", nullable = false, unique = true)
    private String orderNo;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetails;

    @Column(name = "ORDER_DATE", nullable = false)
    private Date orderDate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "TOTAL_AMOUNT", nullable = false)
    private double totalAmount;

    @Column(name = "PAYMENT_INFO", columnDefinition = "TEXT", nullable = false)
    private String paymentInfo;

    @Column(name = "DELIVERY_INFO", columnDefinition = "TEXT", nullable = false)
    private String deliveryInfo;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    // Additional fields can be added as required (e.g., discount, taxes, etc.)
}


