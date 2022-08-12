package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
