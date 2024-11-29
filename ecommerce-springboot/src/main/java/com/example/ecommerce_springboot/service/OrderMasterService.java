package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.OrderMaster;

import java.util.List;

public interface OrderMasterService {
    OrderMaster addOrderMaster(OrderMaster orderMaster);
    OrderMaster updateOrderMaster(Long orderMasterId, OrderMaster orderMaster);
    void deleteOrderMaster(Long orderMasterId);
    OrderMaster getOrderMasterById(Long orderMasterId);
    List<OrderMaster> getAllOrderMasters();
}
