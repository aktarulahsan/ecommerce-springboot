package com.example.ecommerce_springboot.repo;

import com.example.ecommerce_springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom queries can be added here if necessary
}

