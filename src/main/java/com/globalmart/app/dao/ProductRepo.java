package com.globalmart.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	/************************************************************************************
	 * @author Anant Narayan Patel
	 * 
	 *         Description : It is a ProductRepo class that extends Jpa Repository
	 *         interface it provides all the functions to perform crud operations on
	 *         the database and much more.
	 * 
	 *         Version 1.0
	 * 
	 *         Created Date 02-AUG-2022
	 ************************************************************************************/

	List<Product> findAllByProductName(String name);

	void deleteByProductName(String name);
}