package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.ProductService;
import com.globalmart.app.services.ProductServicesInterface;
import com.globalmart.app.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductServicesInterface productService;

	@PostMapping("product")
	public Product addProduct(@Valid @RequestBody Product product) throws ProductException{
		try {
		return productService.addProduct(product);
		}
		catch (ProductException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("product/{id}")
	public Product getProduct(@PathVariable("id") Integer id) throws ProductException {
		return productService.getProductById(id).get();
	}

	//@GetMapping("product/name/{name}")
	//public List<Product> getByName(@RequestParam(value="name") String name) {
	//	return productRepo.findByName(name);
	//}

	@GetMapping("products")
	public List<Product> getAllProducts() throws ProductException{
		return productService.getAllProducts();
	}

	@PutMapping("product")
	public Product updateProduct(@Valid @RequestBody Product product) throws ProductException{
		return productService.updateProduct(product);
	}

	@DeleteMapping("product/{id}")
	public void deleteProductById(@RequestParam(value="productId") Integer productId) throws ProductException {
		productService.deleteProductById(productId);
	}


	@DeleteMapping("product")
	public void deleteProduct(@RequestBody Product product) throws ProductException {
		productService.deleteProduct(product);
	}

}
