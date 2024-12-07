package com.example.ecommerce_springboot.repo;

import com.example.ecommerce_springboot.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderMaster,Long> {

    @Query("SELECT o FROM OrderMaster o WHERE o.customerId = :customerId AND o.orderDate = :orderDate")
    Optional<OrderMaster> findByCustomerIdAndOrderDate(
            @Param("customerId") Long customerId,
            @Param("orderDate") LocalDateTime orderDate
    );
}
