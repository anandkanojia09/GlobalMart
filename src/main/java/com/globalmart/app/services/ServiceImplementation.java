//package com.globalmart.app.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.hibernate.tool.schema.internal.ExceptionHandlerCollectingImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.globalmart.app.controller.CartController;
//import com.globalmart.app.dao.CustomerRepo;
//import com.globalmart.app.dao.ProductRepo;
//import com.globalmart.app.dto.Cart;
//import com.globalmart.app.dto.CustomerDetails;
//import com.globalmart.app.dto.Product;
//
//@RestControllerAdvice
//public class ServiceImplementation implements ServicesInterface {
//
//	@Autowired
//	private ProductRepo productRepo;
//	@Autowired
//	private CustomerRepo customerRepo;
//
//	@Override
//	public boolean addProductToCart(Integer productId, Integer customerId) {
//		boolean productAdded = false;
//		Optional<Product> pId = productRepo.findById(productId);
//		Optional<CustomerDetails> c = customerRepo.findById(customerId);
//		
//		CartController.addCart(new Cart(1,1, 78873, pID, c));
//
//		return productAdded;
//	}
//
//	@ExceptionHandler
//	public String error() {
//		return "Error";
//	}
//}
