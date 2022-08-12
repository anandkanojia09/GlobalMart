package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Order;

public interface OrdersRepo extends JpaRepository<Order, Integer> {

}
