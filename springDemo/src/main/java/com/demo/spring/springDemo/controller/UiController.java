package com.demo.spring.springDemo.controller;

import com.demo.spring.springDemo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    ProductRepo productRepo;
    @Autowired
    public UiController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @GetMapping("/")
    public String viewProducts(Model model){
        model.addAttribute("hello", "Hello CSE");
        return "Hello";
    }

    @GetMapping("/displayProducts")
    public String displayProducts(Model model){
        model.addAttribute("products", productRepo.findAll());
        return "Products";
    }
}