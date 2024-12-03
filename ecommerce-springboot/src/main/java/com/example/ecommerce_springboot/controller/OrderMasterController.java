package com.example.ecommerce_springboot.controller;

import com.example.ecommerce_springboot.entity.OrderMaster;
import com.example.ecommerce_springboot.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
public class OrderMasterController {


    @Autowired
    OrderMasterService service;

    @PostMapping("/save")
    public ResponseEntity<OrderMaster> save(@RequestBody OrderMaster model) {
        OrderMaster createdCategory = service.addOrderMaster(model);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderMaster> update(@RequestBody OrderMaster model) {
        OrderMaster orderMaster = service.updateOrderMaster(model.getOrderId() , model);
        return new ResponseEntity<>(orderMaster, HttpStatus.CREATED);
    }


    @DeleteMapping("/{delete}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteOrderMaster(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a category by ID
    @GetMapping("/{getFindById}")
    public ResponseEntity<OrderMaster> getfindById(@PathVariable Long id) {
        OrderMaster model = service.getOrderMasterById(id);
        return ResponseEntity.ok(model);
    }

    // Get all categories
    @GetMapping("/list")
    public ResponseEntity<List<OrderMaster>> getAllList() {
        List<OrderMaster> list = service.getAllOrderMasters();
        return ResponseEntity.ok(list);
    }
}
