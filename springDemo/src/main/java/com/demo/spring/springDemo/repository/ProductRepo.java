package com.demo.spring.springDemo.repository;

import com.demo.spring.springDemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByName(String name);
    List<Product> findByPrice(double price);
    List<Product> findByNameAndPrice(String name,double price);
    List<Product> findByPriceGreaterThan(double price);
}