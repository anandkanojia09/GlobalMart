package com.globalmart.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findAllByName(String name);

	void deleteByName(String name);

}