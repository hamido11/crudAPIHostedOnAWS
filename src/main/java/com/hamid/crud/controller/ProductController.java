package com.hamid.crud.controller;

import com.hamid.crud.model.Product;
import com.hamid.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    //insert product into DB
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product product1=productService.saveProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }


    //get single product from dB by its ID
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name="product_id") long productid){
        Product getproduct=productService.getProduct(productid);
        return new ResponseEntity<>(getproduct,HttpStatus.OK);
    }


    //get all products
    @GetMapping("/products")
    @CrossOrigin(origins = "*")
  public List<Product> getAllproducts(){
      return productService.getAll();
  }
    //update product in DB
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId")
                                                     long productId,@RequestBody Product product){
        Product updatedProduct=productService.updateProduct(productId,product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    //delete product form DB
    @DeleteMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId")
                                                 long productId){
        Product deleteProduct=productService.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct,HttpStatus.OK);
    }

    //get product by name
    @GetMapping("/products-by-name")
    public List<Product> getProductByName(@RequestParam(name = "productName") String productName){
        return productService.getproductsByName(productName);
    }

}
