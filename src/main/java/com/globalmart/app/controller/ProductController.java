package com.globalmart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	@PostMapping("product")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@GetMapping("product/{id}")
	public Optional<Product> getProduct(@PathVariable("id") Integer id) {
		return productRepo.findById(id);
	}

	@PostMapping("product/update")
	public Product updateProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@DeleteMapping("product/delete/{id}")
	public void deleteProductById(@PathVariable Integer productId) {
		productRepo.deleteById(productId);
	}

	@DeleteMapping("product/delete")
	public void deleteProduct(@PathVariable Product product) {
		productRepo.delete(product);
	}

}
