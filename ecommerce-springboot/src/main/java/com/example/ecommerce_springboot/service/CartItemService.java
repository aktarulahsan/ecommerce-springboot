package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addCartItem(CartItem cartItem);
    CartItem updateCartItem(Long cartId, CartItem cartItem);
    void deleteCartItem(Long cartId);
    CartItem getCartItemById(Long cartId);
    List<CartItem> getAllCartItems();
}

