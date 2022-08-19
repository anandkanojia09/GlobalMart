package com.globalmart.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CartRepo;
import com.globalmart.app.dto.Cart;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.CartException;
import com.globalmart.app.exception.ProductException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired 
	private ProductServicesInterface productService;
	

	@Override
	public Cart addCart(Cart cart) throws CartException {
		if(cart== null) {
			throw new CartException("please provide cart details to add.");
		}
		
		Optional<Cart> cart2 = cartRepo.findById(cart.getCartId());
		if(cart2.isPresent()) {
			throw new CartException("Cart is already exist with this id :");
		}
		else {
			return this.cartRepo.save(cart);
		}
		
	}

	@Override
	public Optional<Cart> getCartById(Integer id) throws CartException {

		Optional<Cart> cart = cartRepo.findById(id);
		if (cart.isEmpty()) {
			throw new CartException("Cart with the id " + id + " is not exist.");
		}

		return cart;
	}

	@Override
	public Cart updateCart(Cart cart) throws CartException {
		
		if(cart==null) {
			throw new CartException("provide data for update. ");
		}
		int x = cart.getCartId();
		if(cartRepo.existsById(x)) {
			cart = cartRepo.save(cart);
			
		}else {
			throw new CartException("No Cart is present as per given credentials.");
		}


		return cart;
	}

	@Override
	public Boolean deleteCartById(Integer id) throws CartException {
		Boolean isCartdeleted = false;
		Optional<Cart> cart = cartRepo.findById(id);
		if (!cart.isEmpty()) {
			cartRepo.deleteById(id);
			isCartdeleted = true;
		} else {
			throw new CartException("Cart can not deleted because it doesn't exist");
		}

		return isCartdeleted;
	}

	@Override
	public Cart addProductToCart(Integer id,Integer productId) throws CartException {
		Cart cart ;
		List<Product> cart2 ;// = new ArrayList<>();
		Optional<Product> product = java.util.Optional.empty() ;
		try {
			product = productService.getProductById(productId);
		} catch (ProductException e) {
			
			e.printStackTrace();
		}	
		cart = this.getCartById(id).get();
		cart2 = cart.getProducts();
		if(cart!= null) {
			cart2.add(product.get());
			cart.setProducts(cart2);
			this.cartRepo.save(cart);
		}
		
		return cart;
	}

	@Override
	public Cart removeProductFromCart(Integer id, Integer productId) throws CartException {
		Cart cart ;
		List<Product> cart2 ;//= new ArrayList<>();
		Optional<Product> product = java.util.Optional.empty() ;
		try {
			product = productService.getProductById(productId);
		} catch (ProductException e) {
			
			e.printStackTrace();
		}	
		cart = this.getCartById(id).get();
		cart2 = cart.getProducts();
		if(cart != null) {
			cart2.remove(product.get());
			cart.setProducts(cart2);
			this.cartRepo.save(cart);
		}
		
		return cart;
	}
	
	

}
