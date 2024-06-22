package com.example.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.Repository.services.ProductRepositoryServices;
import com.example.store.model.ProductEntity;

@RestController
public class ProductController {
    private ProductRepositoryServices prodService;

    @GetMapping("/producst")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        return new ResponseEntity<>(prodService.getAllProducts(),HttpStatus.OK);
    }

}
