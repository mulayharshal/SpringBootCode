package com.Telusko.simpleWebApp.service;

import com.Telusko.simpleWebApp.model.Product;
import com.Telusko.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>( Arrays.asList(
//            new Product(101,"iPhone",5000),
//            new Product(102,"camera",40000),
//            new Product(103,"mic",3000)));

    public List<Product> productList() {
        return repo.findAll();
    }


    public Product getProductId(int prodId) {
        return repo.findById(prodId).get();
    }

    public void addProdect(Product product) {
        repo.save(product);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
