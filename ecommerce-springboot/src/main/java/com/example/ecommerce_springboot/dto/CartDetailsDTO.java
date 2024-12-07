package com.example.ecommerce_springboot.dto;

public class CartDetailsDTO {
    private Long cartDetailsId;
    private String title;
    private Long productId;
    private Double price;
    private int qty;
    private double subtotal;
    private String description;
    private String category;
    private String image;
    private double rating;

    // Constructor
    public CartDetailsDTO(Long cartDetailsId, String title, Long productId, Double price, int qty, double subtotal,
                          String description, String category, String image, double rating) {
        this.cartDetailsId = cartDetailsId;
        this.title = title;
        this.productId = productId;
        this.price = price;
        this.qty = qty;
        this.subtotal = subtotal;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    // Default Constructor
    public CartDetailsDTO() {
    }

    // Getters and Setters
    public Long getCartDetailsId() {
        return cartDetailsId;
    }

    public void setCartDetailsId(Long cartDetailsId) {
        this.cartDetailsId = cartDetailsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
