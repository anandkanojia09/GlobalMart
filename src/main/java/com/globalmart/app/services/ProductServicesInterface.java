package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface ProductServicesInterface {
	/************************************************************************************
	 * @author Anant Narayan Patel
	 * 
	 *         Description : It is the Business Logic Interface for the methods used in the
	 *         controller class.
	 * 
	 *         Version 1.0
	 * 
	 *         Created Date 02-AUG-2022
	 ************************************************************************************/


	public Optional<Product> getProductById(Integer id) throws ProductException;

	public String deleteProductById(Integer productId) throws ProductException;

	public Product addProduct(@RequestBody Product product) throws ProductException;

	public String updateProduct(@RequestBody Product product) throws ProductException;

	public List<Product> getAllProducts() throws ProductException;

	public List<Product> getProductByName(String name) throws ProductException;

	public String deleteByName(String name) throws ProductException;

}
