package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;

@Service
public class ProductService implements ProductServicesInterface {

	@Autowired
	private ProductRepo productRepo;


	public Optional<Product> getProductById(Integer id) throws ProductException {
		Optional<Product> productD = productRepo.findById(id);
		if (!productD.isPresent()) {
			throw new ProductException("Id Not found");
		}
		return productD;
	}

	@Override
	public void deleteProductById(Integer productId) throws ProductException {
		if (productRepo.existsById(productId)) {
			productRepo.deleteById(productId);
			if (productRepo.existsById(productId)) {
				throw new ProductException("Product not deleted");
			}

		} else {
			throw new ProductException("No Product with id " + productId + "found.");

		}

	}

	@Override
	public Product addProduct(Product product) throws ProductException {
		try {
		return productRepo.save(product);
		}
		catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		try {
		return productRepo.findAll();
		}
		catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		try {
		productRepo.save(product);
		return product;
		}
		catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		
	}

	@Override
	public void deleteProduct(Product product) throws ProductException {
		try {
		productRepo.delete(product);
		}
		catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		
	}

//	public List<Product> findByName(String name) {
//		List<Product> prodD = productRepo.
//		return null;
//	}

}
