package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.GlobalMartException;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface ProductServicesInterface {

//	public List<Product> findByName() throws GlobalMartException;

	public Optional<Product> getProductById(Integer id) throws GlobalMartException;

	public void deleteProductById(Integer productId) throws GlobalMartException;

	public Product addProduct(@RequestBody Product product) throws GlobalMartException;

	public Product updateProduct(@RequestBody Product product) throws GlobalMartException;

	public List<Product> getAllProducts() throws GlobalMartException;

	public void deleteProduct(Product product) throws GlobalMartException;

}
