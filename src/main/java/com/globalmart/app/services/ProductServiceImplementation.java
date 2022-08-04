package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.GlobalMartException;

@Service
public class ProductServiceImplementation implements ProductServicesInterface {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ProductRepo productRepo;


	public Optional<Product> getProductById(Integer id) throws GlobalMartException {
		Optional<Product> productD = productRepo.findById(id);
		if (productD.isEmpty()) {
			throw new GlobalMartException("Id Not found");
		}
		return productD;
	}

	@Override
	public void deleteProductById(Integer productId) throws GlobalMartException {
		if (productRepo.existsById(productId)) {
			productRepo.deleteById(productId);
			if (productRepo.existsById(productId)) {
				throw new GlobalMartException("Product not deleted");
			}

		} else {
			throw new GlobalMartException("No Product with id " + productId + "found.");

		}

	}

	@Override
	public Product addProduct(Product product) throws GlobalMartException {
		try {
		return productRepo.save(product);
		}
		catch (Exception e) {
			throw new GlobalMartException(e.getMessage());
		}
	}

	@Override
	public List<Product> getAllProducts() throws GlobalMartException {
		try {
		return productRepo.findAll();
		}
		catch (Exception e) {
			throw new GlobalMartException(e.getMessage());
		}
		
	}

	@Override
	public Product updateProduct(Product product) throws GlobalMartException {
		try {
		productRepo.save(product);
		return product;
		}
		catch (Exception e) {
			throw new GlobalMartException(e.getMessage());
		}
		
	}

	@Override
	public void deleteProduct(Product product) throws GlobalMartException {
		try {
		productRepo.delete(product);
		}
		catch (Exception e) {
			throw new GlobalMartException(e.getMessage());
		}
		
	}

//	public List<Product> findByName(String name) {
//		List<Product> prodD = productRepo.
//		// TODO Auto-generated method stub
//		return null;
//	}

}
