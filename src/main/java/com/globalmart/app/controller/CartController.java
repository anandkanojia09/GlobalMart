 package com.globalmart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Cart;
import com.globalmart.app.exception.CartException;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.CartService;


/************************************************************************************
 * @author -      Abhishek Kumar Jaiswal 
 * Description -  This is controller of Cart Module in which all the API's are defined.
 * 
 * Created Date - 16-AUG-2022
 ************************************************************************************/
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	/************************************************************************************
	 * Method:                   addCart 
	 * Description:              To add/create a new Cart
	 * 
	 * @param cart -             Cart details of new cart
	 * @returns Cart -           Cart added or created otherwise throws CartException
	 * @throws CartException -   It is raised due to when cart is null or when user
	 *                           add a cart with id which is already used.
	 * 
	 * Created By -              Abhishek Kumar Jaiswal 
	 * Created Date -            16-AUG-2022
	 * 
	 ************************************************************************************/


	@PostMapping("cart")
	public Cart addCart(@RequestBody Cart cart) throws CartException {

		try {
			this.cartService.addCart(cart);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
		return cart;
	}
	
	
	/************************************************************************************
	 * Method:                   getCartById 
	 * Description:              For getting details of a Cart by its Id.
	 * 
	 * @param id -               cartID of Cart.
	 * @returns cart - -         return the details of Cart otherwise throws CartException
	 * @throws CartException -   It is raised due to when No Cart available related to
	 *                           that cartId or no cart exist related to id. 
	 *        
	 * Created By -              Abhishek Kumar Jaiswal 
	 * Created Date -            16-AUG-2022
	 * 
	 ************************************************************************************/

	@GetMapping("cart/{id}")
	public Optional<Cart> getCartById(@PathVariable("id") Integer cartId) throws CartException {
		Optional<Cart> cart = null;
		try {
			cart = this.cartService.getCartById(cartId);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
		return cart;
	}
	
	/************************************************************************************
	 * Method :                  updateCart 
	 * Description:              To update the details of a Cart
	 * 
	 * @param cart -             Cart details which is going to updated.
	 * @returns Cart -           Return the updated vaule of Cart otherwise throws CartException.
	 * @throws CartException -   It is raised due to when cart is null or when cart
	 *                           details is not related to any Cart.
	 * 
	 * Created By -              Abhishek Kumar Jaiswal 
	 * Created Date -            16-AUG-2022
	 * 
	 ************************************************************************************/
	

	@PatchMapping("cart")
	public Cart updateCart(@RequestBody Cart cart) throws CartException {
		try {
			this.cartService.updateCart(cart);
		} catch (CartException e) {
			e.getMessage();
		}
		return cart;
	}

	

	/************************************************************************************
	 * Method:                   deleteCartById 
	 * Description:              To add/create a new Cart
	 * 
	 * @param id -               Id of that Cart which is going to deleted.
	 * @returns void
	 * @throws CartException -   It is raised due to when there is no cart available
	 *                           related to that id.
	 * 
	 * Created By -              Abhishek Kumar Jaiswal
	 * Created Date-             16-AUG-2022
	 * 
	 ************************************************************************************/
	
	@DeleteMapping("cart/{id}")
	public void deleteCartById(@PathVariable("id") Integer cartId) throws CartException {
		try {
			cartService.deleteCartById(cartId);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
	}

	
	/************************************************************************************
	 * Method :                   addProductById 
	 * Description :              To add a product into a Cart
	 * 
	 * @param cartId     -        cart id of the Cart
	 * @param productId-          product id of the Product
	 * @returns Cart -            Cart with added product otherwise throws CartException
	 * @throws CartException    - It is raised due to when cart is null or when user add a cart with id which is not exist.
	 *                           
	 * Created By -               Abhishek Kumar Jaiswal 
	 * Created Date -             16-AUG-2022
	
	 * 
	 ************************************************************************************/
	@PatchMapping("cart/addproduct/cart{id}")
	public String addProductById(@PathVariable("id") Integer cartId, Integer productid) throws CartException, ProductException {

		try {
			cartService.addProductToCart(cartId, productid);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
		return "product added in cart Successfully.";
	}

	/************************************************************************************
	 * Method:                   removeProductById 
	 * Description:              To remove a product from a Cart
	 * 
	 * @param cartId     -       cart id of the Cart
	 * @param productId-         product id of the Product
	 * @returns Cart -           Cart, after updated product quantity otherwise throws CartException
	 * @throws CartException -   It is raised due to when cart is not exist.
	 * 
	 * Created By -              Abhishek Kumar Jaiswal 
	 * Created Date -            16-AUG-2022
	 * 
	 ************************************************************************************/
	@PatchMapping("cart/removeproduct/cart{id}")
	public String removeProductById(@PathVariable("id") Integer cartId, Integer productid) throws CartException, ProductException{
		try {
			cartService.removeProductFromCart(cartId, productid);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
		return " product removed from cart successfully.";
	}
	
	
	/************************************************************************************
	 * Method:                     increaseProductQuantity
	 * Description:                To increase product quantity in a Cart
	 * 
	 * @param cartId     -         cart id of the Cart
	 * @param productId-           product id of the Product
	 * @param quantity-            the quantity of product to be added
	 * @returns Cart -             Cart, after removed product quantity otherwise throws CartException
	 * @throws CartException -     It is raised when the quantity is more than available product quantity. 
	 *  
	 * Created By -                Abhishek Kumar Jaiswal  
	 * Created Date -              16-AUG-2022
	 * 
	 ************************************************************************************/
	
	@PatchMapping("cart/increaseproductquantiy/cart{id}")
	public String increaseProductByIdInCart(@PathVariable("id") Integer cartId , Integer productId , Integer quantity) throws CartException , ProductException{
		try {
			cartService.increaseProductQuantity(cartId, productId, quantity);
		} catch(CartException e) {
			throw new CartException(e.getMessage());
		}
		return "cart quantity updated";
	}
	
	/************************************************************************************
	 * Method:                   decreaseProductQuantity
	 * Description:              To decrease product quantity in a Cart
	 * 
	 * @param cartId     -       cart id of the Cart
	 * @param productId-         product id of the Product
	 * @param quantity-          the quantity of product to be romvoed
	 * @returns Cart -           Cart, after removed product otherwise throws CartException
	 * @throws CartException -   It is raised when the quantity is more than availabe product quantity. 
	 * 
	 * Created By -              Abhishek Kumar Jaiswal 
	 * Created Date -            16-AUG-2022
	 * 
	 ************************************************************************************/
	
	@PatchMapping("cart/decreaseproductquantiy/cart{id}")
	public String decreaseProductByIdInCart(@PathVariable("id") Integer cartId , Integer productId , Integer quantity) throws CartException , ProductException{
		try {
			cartService.decreaseProductQuantity(cartId, productId, quantity);
		} catch(CartException e) {
			throw new CartException(e.getMessage());
		}
		return "cart quantity updated";
	}
}
