package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.dto.CartDetailsDTO;
import com.example.ecommerce_springboot.dto.CartItemDTO;
import com.example.ecommerce_springboot.entity.CartItem;
import com.example.ecommerce_springboot.repo.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

//    @Override
//    public CartItem addCartItem(CartItem cartItem) {
//        return cartItemRepository.save(cartItem);
//    }


    @Transactional
    @Override
    public CartItem addCartItem(CartItem cartItem) {
        // Set the bidirectional relationship between CartItem and CartDetails
        if (cartItem.getCartDetails() != null) {
            cartItem.getCartDetails().forEach(cartDetails -> cartDetails.setCartItem(cartItem));
        }

        // Save the CartItem, cascading saves its CartDetails as well
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

//    @Override
//    public CartItem getCartItemById(Long cartId) {
//        return cartItemRepository.findById(cartId)
//                .orElseThrow(() -> new RuntimeException("CartItem with ID " + cartId + " not found."));
//    }

//    @Override
//    public List<CartItem> getAllCartItems() {
//        return cartItemRepository.findAll();
//    }

//    public List<CartItemDTO> getAllCartItems() {
        @Override
        public List<CartItemDTO> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();

        return cartItems.stream().map(cartItem -> {
            List<CartDetailsDTO> cartDetailsDTOs = cartItem.getCartDetails().stream()
                    .map(details -> new CartDetailsDTO(
                            details.getCartDetailsId(),
                            details.getTitle(),
                            details.getProductId(),
                            details.getPrice(),
                            details.getQty(),
                            details.getSubtotal(),
                            details.getDescription(),
                            details.getCategory(),
                            details.getImage(),
                            details.getRating()
                    ))
                    .collect(Collectors.toList());

            return new CartItemDTO(
                    cartItem.getCartId(),
                    cartDetailsDTOs,
                    cartItem.getItemCount(),
                    cartItem.getTotalPrice()
            );
        }).collect(Collectors.toList());
    }


//    public CartItemDTO getCartItem(Long cartId) {
        @Override
        public CartItemDTO getCartItemById(Long cartId) {
        CartItem cartItem = cartItemRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));

        List<CartDetailsDTO> cartDetailsDTOs = cartItem.getCartDetails().stream()
                .map(details -> new CartDetailsDTO(
                        details.getCartDetailsId(),
                        details.getTitle(),
                        details.getProductId(),
                        details.getPrice(),
                        details.getQty(),
                        details.getSubtotal(),
                        details.getDescription(),
                        details.getCategory(),
                        details.getImage(),
                        details.getRating()
                ))
                .collect(Collectors.toList());

        return new CartItemDTO(
                cartItem.getCartId(),
                cartDetailsDTOs,
                cartItem.getItemCount(),
                cartItem.getTotalPrice()
        );
    }

}
