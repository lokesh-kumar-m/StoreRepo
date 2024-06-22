package com.example.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    
}
