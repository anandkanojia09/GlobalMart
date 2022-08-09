package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;

@Service
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
	public Optional<Product> deleteProductById(Integer productId) throws ProductException {
		if (productRepo.existsById(productId)) {
			Optional<Product> tempProduct = this.getProductById(productId);
			productRepo.deleteById(productId);
			return (tempProduct);
		} else {
			throw new ProductException("No Product with id " + productId + " found.");

		}
	}

	@Override
	public Product addProduct(Product product) throws ProductException {
		Integer productId = product.getId();
		Boolean flag = false;
		if (!productRepo.existsById(productId)) {
			flag = true;
			return productRepo.save(product);
		}
		if (flag == false) {
			throw new ProductException("Product with ID " + productId + " Already Present");
		} else {
			return product;
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
	public Product updateProduct(Product product) throws ProductException {
		try {
			productRepo.save(product);
			return product;
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}

	}

	@Override
	public void deleteProduct(Product product) throws ProductException {
		try {
			productRepo.delete(product);
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
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
			if (!productRepo.findAllByName(name).isEmpty()) {
				throw new ProductException("Delete operation unsuccessful");
			} else
				return ("Delete operation successful");
		} else {
			throw new ProductException("No product with name " + name + " found");
		}
	}

}
