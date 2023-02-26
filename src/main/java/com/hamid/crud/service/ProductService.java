package com.hamid.crud.service;

import com.hamid.crud.model.Product;
import com.hamid.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public Product getProduct(long productId){
      return repository.findById(productId).orElseThrow(() -> new RuntimeException("not found"));

    }
    public List<Product> getAll(){
        return repository.findAll();
    }
    public Product updateProduct(long producId,Product product){
        Product exsistingProduct=repository.findById(producId).orElseThrow(() -> new RuntimeException("not found"));

        exsistingProduct.setName(product.getName());
        exsistingProduct.setColor(product.getColor());
        exsistingProduct.setPrice(product.getPrice());
        repository.save(exsistingProduct);
        return exsistingProduct ;

    }
    public Product deleteProduct(long productId ){
        Product product=repository.findById(productId).orElseThrow(() -> new RuntimeException("not found"));
        repository.delete(product);
        return product;
    }
    public List<Product> getproductsByName(String productName){
     return repository.getProductsByName(productName);

    }

}
