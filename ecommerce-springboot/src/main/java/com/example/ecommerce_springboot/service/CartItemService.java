package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.dto.CartItemDTO;
import com.example.ecommerce_springboot.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addCartItem(CartItem cartItem);
    CartItem updateCartItem(Long cartId, CartItem cartItem);
    void deleteCartItem(Long cartId);
    CartItemDTO getCartItemById(Long cartId);
    List<CartItemDTO> getAllCartItems();
}

