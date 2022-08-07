package com.globalmart.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmart.app.dto.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAllByName(String name);

    void deleteByName(String name);
}
