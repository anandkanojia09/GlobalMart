package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
