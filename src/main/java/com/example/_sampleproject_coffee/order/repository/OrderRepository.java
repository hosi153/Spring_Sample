package com.example._sampleproject_coffee.order.repository;

import com.example._sampleproject_coffee.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
