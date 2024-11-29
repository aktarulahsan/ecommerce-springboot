package com.example.ecommerce_springboot.repo;
import com.example.ecommerce_springboot.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Additional custom queries can be added here if needed
}

