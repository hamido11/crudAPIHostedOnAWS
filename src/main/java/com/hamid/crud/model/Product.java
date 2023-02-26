package com.hamid.crud.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name ="product_inventory")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name",nullable = false)
    private String name;
   @Column(name = "color")
    private String color;
   @Column(name = "price")
   private int price ;
}
