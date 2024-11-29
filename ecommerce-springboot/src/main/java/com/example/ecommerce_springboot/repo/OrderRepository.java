package com.example.ecommerce_springboot.repo;

import com.example.ecommerce_springboot.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderMaster,Long> {
}
