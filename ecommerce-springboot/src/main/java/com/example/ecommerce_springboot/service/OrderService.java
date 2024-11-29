package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.OrderMaster;
import com.example.ecommerce_springboot.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderMaster createOrder(OrderMaster order){
        return orderRepository.save(order);
    }
    public Optional<OrderMaster> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    // Additional CRUD methods

}
