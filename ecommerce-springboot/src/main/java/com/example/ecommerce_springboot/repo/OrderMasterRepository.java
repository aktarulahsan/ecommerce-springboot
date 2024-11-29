package com.example.ecommerce_springboot.repo;

import com.example.ecommerce_springboot.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long> {
    // Additional custom queries can be added here if necessary
}

