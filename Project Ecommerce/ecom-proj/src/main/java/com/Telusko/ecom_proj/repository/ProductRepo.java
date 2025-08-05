package com.Telusko.ecom_proj.repository;

import com.Telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    public List<Product> findByBrand(String brand);

//    JPQL -
    @Query("SELECT p from Product p WHERE "+"p.name LIKE LOWER(concat('%' ,:keyword,'%')) OR "+
                "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
                "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
                "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
                "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%')) "
            )
    List<Product> searchProduct(String Keyword);
}
