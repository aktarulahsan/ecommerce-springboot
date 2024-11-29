//package com.example.ecommerce_springboot.service;
//
//import com.example.ecommerce_springboot.repo.CheckoutRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//@Service
//public class CheckoutService {
//    @Autowired
//    private CheckoutRepository checkoutRepository;
//
//    public Checkout createCheckout(Checkout checkout){
//        return checkoutRepository.save(checkout);
//    }
//    public Optional<Checkout> getCheckout(Long id) {
//        return checkoutRepository.findById(id);
//    }
//}
