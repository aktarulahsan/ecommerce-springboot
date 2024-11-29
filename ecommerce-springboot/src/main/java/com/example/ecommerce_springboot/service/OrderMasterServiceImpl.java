package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.OrderMaster;
import com.example.ecommerce_springboot.repo.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    private final OrderMasterRepository orderMasterRepository;

    @Autowired
    public OrderMasterServiceImpl(OrderMasterRepository orderMasterRepository) {
        this.orderMasterRepository = orderMasterRepository;
    }

    @Override
    public OrderMaster addOrderMaster(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public OrderMaster updateOrderMaster(Long orderMasterId, OrderMaster orderMaster) {
        Optional<OrderMaster> existingOrderMaster = orderMasterRepository.findById(orderMasterId);
        if (existingOrderMaster.isPresent()) {
            OrderMaster updatedOrderMaster = existingOrderMaster.get();
            updatedOrderMaster.setCustomerId(orderMaster.getCustomerId());
            updatedOrderMaster.setOrderDate(orderMaster.getOrderDate());
            updatedOrderMaster.setPaymentInfo(orderMaster.getPaymentInfo());
            updatedOrderMaster.setDeliveryInfo(orderMaster.getDeliveryInfo());
            updatedOrderMaster.setTotalAmount(orderMaster.getTotalAmount());
            // Update additional fields here
            return orderMasterRepository.save(updatedOrderMaster);
        } else {
            throw new RuntimeException("OrderMaster with ID " + orderMasterId + " not found.");
        }
    }

    @Override
    public void deleteOrderMaster(Long orderMasterId) {
        orderMasterRepository.deleteById(orderMasterId);
    }

    @Override
    public OrderMaster getOrderMasterById(Long orderMasterId) {
        return orderMasterRepository.findById(orderMasterId)
                .orElseThrow(() -> new RuntimeException("OrderMaster with ID " + orderMasterId + " not found."));
    }

    @Override
    public List<OrderMaster> getAllOrderMasters() {
        return orderMasterRepository.findAll();
    }
}

