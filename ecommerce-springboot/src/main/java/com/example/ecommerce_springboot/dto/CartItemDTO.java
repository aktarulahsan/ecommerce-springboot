package com.example.ecommerce_springboot.dto;
import java.util.List;

public class CartItemDTO {
    private Long cartId;
    private List<CartDetailsDTO> cartDetails;
    private int itemCount;
    private double totalPrice;

    // Constructor
    public CartItemDTO(Long cartId, List<CartDetailsDTO> cartDetails, int itemCount, double totalPrice) {
        this.cartId = cartId;
        this.cartDetails = cartDetails;
        this.itemCount = itemCount;
        this.totalPrice = totalPrice;
    }

    // Default Constructor
    public CartItemDTO() {
    }

    // Getters and Setters
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartDetailsDTO> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetailsDTO> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
