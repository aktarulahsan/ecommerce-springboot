package com.example.ecommerce_springboot.controller;

import com.example.ecommerce_springboot.entity.CartItem;
import com.example.ecommerce_springboot.entity.Category;
import com.example.ecommerce_springboot.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {

    @Autowired
    CartItemService service;

    @PostMapping("/save")
    public ResponseEntity<CartItem> addCategory(@RequestBody CartItem category) {
        CartItem createdCategory = service.addCartItem(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CartItem> updateCategory(@RequestBody CartItem model) {
        CartItem createdCategory = service.updateCartItem(model.getCartId() , model);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }


    @DeleteMapping("/{delete}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCartItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a category by ID
    @GetMapping("/{getFindById}")
    public ResponseEntity<CartItem> getCategoryById(@PathVariable Long id) {
        CartItem model = service.getCartItemById(id);
        return ResponseEntity.ok(model);
    }

    // Get all categories
    @GetMapping("/list")
    public ResponseEntity<List<CartItem>> getAllCategories() {
        List<CartItem> list = service.getAllCartItems();
        return ResponseEntity.ok(list);
    }

}
