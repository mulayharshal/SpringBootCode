package com.Telusko.ecom_proj.controller;

import com.Telusko.ecom_proj.model.Product;
import com.Telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>( service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try {
            Product product1=    service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{prouctId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int prouctId){
        Product product = service.getProductById(prouctId);
        byte[] image = product.getImageData();

        return  ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(image);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product product1 = null;
        try{
            product1=service.updateProduct(id,product,imageFile);
        }catch (Exception e){
            return new ResponseEntity<>("Failed not updated", HttpStatus.NOT_FOUND);
        }
        if(product1 != null) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);

        }else {
            return new ResponseEntity<>("Failed not deleted", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String Keyword){
        System.out.println(Keyword);
        List<Product> products=service.searchProducts(Keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }
}
