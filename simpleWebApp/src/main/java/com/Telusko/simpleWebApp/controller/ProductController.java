package com.Telusko.simpleWebApp.controller;

import com.Telusko.simpleWebApp.model.Product;
import com.Telusko.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){

       return service.productList();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductId(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
         service.addProdect(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProductById(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
