package com.globalmart.app.services;

import java.util.Optional;

import com.globalmart.app.dto.Cart;
import com.globalmart.app.exception.CartException;
import com.globalmart.app.exception.ProductException;

public interface CartService {
	
	public Cart addCart(Cart cart) throws CartException;
	
	public Optional<Cart> getCartById(Integer id) throws CartException;
	
	public Cart updateCart(Cart cart) throws CartException;
	
	public Boolean deleteCartById(Integer id) throws CartException;
	
	public Cart addProductToCart(Integer id ,Integer productId) throws CartException, ProductException;
	
	public Cart removeProductFromCart(Integer id ,Integer productId) throws CartException;
}
