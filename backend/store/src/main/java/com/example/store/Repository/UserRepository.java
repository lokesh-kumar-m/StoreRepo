package com.example.store.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
    Optional<UserEntity> findByUserName(String name);
    boolean existsByUserName(String name);
}
