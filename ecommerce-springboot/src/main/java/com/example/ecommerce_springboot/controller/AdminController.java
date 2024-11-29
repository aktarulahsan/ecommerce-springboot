package com.example.ecommerce_springboot.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String dashboard(Model model) {
        // Add any attributes you want to show in the admin panel
        return "admin/dashboard";
    }
}

