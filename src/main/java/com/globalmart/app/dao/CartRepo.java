package com.globalmart.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

	void save(Optional<Cart> cart);

}
