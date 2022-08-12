package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmart.app.dto.Category;

@Repository
public interface CategoryRepo extends JpaRepository <Category, Integer> {
	Boolean existsByName(String name);
}
