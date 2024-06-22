package com.example.store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.Repository.services.OrderRepositoryService;
import com.example.store.model.OrdersEntity;

@RestController
public class OrderController {
    private OrderRepositoryService orderServices;

    @GetMapping("/mylist/{name}")
    public List<OrdersEntity> getMyList(@PathVariable String name){
        return orderServices.getMyItems(name);
    }


}
