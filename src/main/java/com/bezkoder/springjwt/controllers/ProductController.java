package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Product;
import com.bezkoder.springjwt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("api/test")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


   @GetMapping("/products")
     //public String allAccess() { return "halaman produk"; }
     //public List<Product> getAllProduct() { return productRepository.findAll(); }

    public List<Product> getAll(){
       return productRepository.findAll();
   }
}
