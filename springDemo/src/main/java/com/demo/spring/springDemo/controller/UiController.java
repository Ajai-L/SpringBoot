package com.demo.spring.springDemo.controller;

import com.demo.spring.springDemo.model.Product;
import com.demo.spring.springDemo.repository.ProductRepo;
import com.demo.spring.springDemo.repository.UserRepo; // 1. Import UserRepo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UiController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/")
    public String homePage(){
        return "Hello";
    }

    @GetMapping("/products-ui")
    public String displayProducts(Model model){
        model.addAttribute("products", productRepo.findAll());
        return "productlist";
    }

    @GetMapping("/users-ui")
    public String displayUsers(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userlist";
    }

    @GetMapping("/addProduct")
    public String saveAddProductFrom(Model model){
        model.addAttribute("product", new Product());
        return "AddProduct";
    }

    @PostMapping("/save")
    public String saveProductToDb(@ModelAttribute Product product){
        productRepo.save(product);
        return "redirect:/products-ui";
    }
}