package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;

@Service
@Transactional
public class ProductServiceImpl implements ProductServicesInterface {

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
	public String deleteProductById(Integer productId) throws ProductException {
		if (productRepo.existsById(productId)) {
			productRepo.deleteById(productId);
			return ("Product With ID " + productId + " Deleted Successfully.");
		} else {
			throw new ProductException("No Product with id " + productId + " found.");
		}
	}

	@Override
	public String addProduct(Product product) throws ProductException {
		Integer productId = product.getId();
		if (!productRepo.existsById(productId)) {
			return product.toString();
		} else {
			throw new ProductException("Product with ID " + productId + " already present in Database.");
		}
	}

	@Override
	public String updateProduct(Product product) throws ProductException {
		Integer productId = product.getId();
		if (productRepo.existsById(productId)) {
			productRepo.save(product);
			return product.toString();
		} else {
			throw new ProductException("Product not found in Database, can't Update.");
		}
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> allProducts = productRepo.findAll();
		if (!allProducts.isEmpty()) {
			return allProducts;
		} else {
			throw new ProductException("Product Table Empty.");
		}
	}

	@Override
	public List<Product> getProductByName(String name) throws ProductException {
		List<Product> prodD = productRepo.findAllByName(name);
		if (!prodD.isEmpty()) {
			return prodD;
		} else {
			throw new ProductException("No Product matching the given name : " + name);
		}
	}

	@Override
	public String deleteByName(String name) throws ProductException {
		if (!productRepo.findAllByName(name).isEmpty()) {
			productRepo.deleteByName(name);
			return ("Delete operation successful");
		} else {
			throw new ProductException("No product with name " + name + " found");
		}
	}

}
