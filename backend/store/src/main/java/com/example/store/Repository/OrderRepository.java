package com.example.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.store.model.OrdersEntity;

import jakarta.transaction.Transactional;

public interface OrderRepository extends JpaRepository<OrdersEntity,Integer> {
    @Modifying
    @Transactional
    @Query("update OrdersEntity e set e.quantity=:quantity where e.id=:id")
    void updateQuantity(@Param(value="id")int id,@Param(value="quantity")int quantity);
}
