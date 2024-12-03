package com.example.ecommerce_springboot.repo;

import com.example.ecommerce_springboot.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
//    List<OrderDetails> findByOrderMasterId(Long orderMasterId); // Custom query to find all OrderDetails by OrderMaster ID
}

