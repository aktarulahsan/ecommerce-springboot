package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.Customer;
import com.example.ecommerce_springboot.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Long customerId, Customer customer);
    void deleteCustomer(Long customerId);
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();
}

