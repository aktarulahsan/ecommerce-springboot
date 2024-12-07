package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.OrderMaster;
import com.example.ecommerce_springboot.repo.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public OrderMaster createOrder(OrderMaster order) {
        // Check for duplicates (e.g., based on `customerId` and `orderDate`)
        Optional<OrderMaster> existingOrder = orderRepository.findByCustomerIdAndOrderDate(
                order.getCustomerId(),
                order.getOrderDate()
        );
        if (existingOrder.isPresent()) {
            throw new IllegalArgumentException("Duplicate order detected for customer ID: " + order.getCustomerId());
        }

        // Set bidirectional relationship
        if (order.getOrderDetails() != null) {
            order.getOrderDetails().forEach(detail -> detail.setOrderMaster(order));
        }

        return orderRepository.save(order);
    }
    public Optional<OrderMaster> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    // Additional CRUD methods

}
