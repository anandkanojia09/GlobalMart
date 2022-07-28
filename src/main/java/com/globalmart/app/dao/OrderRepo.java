package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Orders;

public interface OrderRepo  extends JpaRepository<Orders, Integer>{



}
