package com.globalmart.app.dao;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmart.app.dto.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//	List<Product> findByName(String name);

//	public List<Product> findByName(String name);
}
