package com.hamid.crud.repository;

import com.hamid.crud.model.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query(value = "select * from product_inventory where product_name=?1",nativeQuery = true)
    public List<Product> getProductsByName( String productName);

}
