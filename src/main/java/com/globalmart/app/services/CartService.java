package com.globalmart.app.services;

import java.util.Optional;

import com.globalmart.app.dto.Cart;
import com.globalmart.app.exception.CartException;
import com.globalmart.app.exception.ProductException;


/************************************************************************************
 * @author Abhishek Kumar Jaiswal
 * 
 *         Description : These are the services which is used by user in Cart related Operation.
 * 
 *        
 * 
 *         Created Date 02-AUG-2022
 ************************************************************************************/
public interface CartService {
	
	public Cart addCart(Cart cart) throws CartException;
	
	public Optional<Cart> getCartById(Integer id) throws CartException;
	
	public Cart updateCart(Cart cart) throws CartException;
	
	public Boolean deleteCartById(Integer id) throws CartException;
	
	public Cart addProductToCart(Integer id ,Integer productId) throws CartException, ProductException;
	
	public Cart removeProductFromCart(Integer id ,Integer productId) throws CartException, ProductException;
	
	public Cart increaseProductQuantity(Integer id, Integer productId, Integer quantity) throws CartException , ProductException;

	 public Cart decreaseProductQuantity(Integer id, Integer productId, Integer quantity) throws CartException, ProductException;
}
