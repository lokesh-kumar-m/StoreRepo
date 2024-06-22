package com.example.store.Repository.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.store.Repository.ProductRepository;
import com.example.store.model.ProductEntity;

@Service
public class ProductRepositoryServices {
   private ProductRepository productRepo;

    public ProductRepositoryServices(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
   
    public String addNewProduct(String prodName, int pnumbers, float price){
        ProductEntity prod=new ProductEntity();
        prod.setName(prodName);
        prod.setNumbers(pnumbers);
        prod.setPrice(price);
        productRepo.save(prod);
        return "created prod";
    }
    public List<ProductEntity> getAllProducts(){
        return productRepo.findAll();
    }
}
