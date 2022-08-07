package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface ProductServicesInterface {

	public Optional<Product> getProductById(Integer id) throws ProductException;

	public void deleteProductById(Integer productId) throws ProductException;

	public Product addProduct(@RequestBody Product product) throws ProductException;

	public Product updateProduct(@RequestBody Product product) throws ProductException;

	public List<Product> getAllProducts() throws ProductException;

	public void deleteProduct(Product product) throws ProductException;

	public List<Product> getProductByName(String name) throws ProductException;

	public void deleteByName(String name) throws ProductException;

}
