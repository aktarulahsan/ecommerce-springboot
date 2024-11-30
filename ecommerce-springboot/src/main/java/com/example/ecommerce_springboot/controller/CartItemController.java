package com.example.ecommerce_springboot.controller;

import com.example.ecommerce_springboot.entity.CartItem;
import com.example.ecommerce_springboot.entity.Category;
import com.example.ecommerce_springboot.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
