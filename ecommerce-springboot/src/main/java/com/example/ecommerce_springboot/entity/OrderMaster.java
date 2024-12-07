package com.example.ecommerce_springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
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

//    @Column(name = "ORDER_NO" )
//    private String orderNo;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

//    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<OrderDetails> orderDetails;


//    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<OrderDetails> orderDetails;
//
//    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderDetails> orderDetails;


    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "STATUS" )
    private String status;

    @Column(name = "TOTAL_AMOUNT" )
    private double totalAmount;

    @Column(name = "PAYMENT_INFO" )
    private String paymentInfo;

    @Column(name = "DELIVERY_INFO" )
    private String deliveryInfo;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;


//    @Column(nullable = false)
//    private LocalDateTime orderDate;

    // Additional fields can be added as required (e.g., discount, taxes, etc.)
}


