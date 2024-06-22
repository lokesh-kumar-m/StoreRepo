package com.example.store.Repository.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.example.store.Repository.OrderRepository;
import com.example.store.model.OrdersEntity;

@Service
public class OrderRepositoryService {
    private OrderRepository orderRepo;

    public OrderRepositoryService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    public List<OrdersEntity> getMyItems(String name){
        Predicate<? super OrdersEntity> predicate=list->list.getUserName().equalsIgnoreCase(name);
        List<OrdersEntity> items=orderRepo.findAll().stream().filter(predicate).toList();
        return items;
    }
    public String addItem(String name,String prodName,int quant,float cost){
        OrdersEntity item=new OrdersEntity();
        item.setUserName(name);
        item.setProductName(prodName);
        item.setQuantity(quant);
        item.setCost(cost);
        orderRepo.save(item);
        return "Added";
    }

    public void deleteItem(int id){
        orderRepo.deleteById(id);
    }

    public void updateQuant(int id,int quantity){
        orderRepo.updateQuantity(id, quantity);
    }
}
