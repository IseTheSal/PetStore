package com.example.demo.repository;

import com.example.demo.domain.OrderPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderPet, Integer> {
}
