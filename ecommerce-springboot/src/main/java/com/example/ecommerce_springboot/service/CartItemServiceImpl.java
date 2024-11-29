package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.CartItem;
import com.example.ecommerce_springboot.repo.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long cartId, CartItem cartItem) {
        Optional<CartItem> existingCartItem = cartItemRepository.findById(cartId);
        if (existingCartItem.isPresent()) {
            CartItem updatedCartItem = existingCartItem.get();
            updatedCartItem.setItemCount(cartItem.getItemCount());
            updatedCartItem.setTotalPrice(cartItem.getTotalPrice());
           // updatedCartItem.setCartDetails(cartItem.getCartDetails());
            return cartItemRepository.save(updatedCartItem);
        } else {
            throw new RuntimeException("CartItem with ID " + cartId + " not found.");
        }
    }

    @Override
    public void deleteCartItem(Long cartId) {
        cartItemRepository.deleteById(cartId);
    }

    @Override
    public CartItem getCartItemById(Long cartId) {
        return cartItemRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("CartItem with ID " + cartId + " not found."));
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
}
