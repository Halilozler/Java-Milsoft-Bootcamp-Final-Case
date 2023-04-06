package com.example.backendrest.data.repository;

import com.example.backendrest.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select p FROM Product p WHERE p.category.categoryId =:categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") long categoryId);

    @Query("select p FROM Product p WHERE p.ProductId =: productId")
    List<Product> findProductsByProductId(@Param("productId") long productId);
}
