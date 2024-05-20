package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> searchProduct(String keyword);
}
