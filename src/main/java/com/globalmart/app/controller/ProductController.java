package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.ProductServiceImplementation;
import com.globalmart.app.services.ProductServiceImplementation;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ProductServiceImplementation serviceImpl;

	@PostMapping("product")
	public Product addProduct(@RequestBody Product product) throws GlobalMartException{
		return serviceImpl.addProduct(product);
	}

//	@GetMapping("product/{id}")
//	public Optional<Product> getProduct(@PathVariable("id") Integer id) {
//		return productRepo.findById(id);
//	}
	@GetMapping("product/{id}")
	public Optional<Product> getProduct(@PathVariable("id") Integer id) throws GlobalMartException {
		return serviceImpl.getProductById(id);
	}

//	@GetMapping("product/{name}")
//	public List<Product> getByName(@RequestParam(value="name") String name) {
//		return productRepo.findByName(name);
//	}

//	@GetMapping("product/{name}")
//	public List<Product> getByName(@RequestParam(value="name") String name) {
//		return serviceImpl.findByName(name);
//	}

	@GetMapping("product/all")
	public List<Product> getAllProducts() throws GlobalMartException{
		return serviceImpl.getAllProducts();
	}

	@PostMapping("product/update")
	public Product updateProduct(@RequestBody Product product) throws GlobalMartException{
		return serviceImpl.updateProduct(product);
	}

	@DeleteMapping("product/delete/{id}")
	public void deleteProductById(@RequestParam(value="productId") Integer productId) throws GlobalMartException {
		serviceImpl.deleteProductById(productId);
	}


	@DeleteMapping("product/delete")
	public void deleteProduct(@PathVariable Product product) throws GlobalMartException {
		serviceImpl.deleteProduct(product);
	}

}
