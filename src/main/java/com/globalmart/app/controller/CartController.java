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
import com.globalmart.app.services.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("cart")
	public Cart addCart(@RequestBody Cart cart) throws CartException {

		try {
			this.cartService.addCart(cart);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
		return cart;
	}

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

	@PatchMapping("cart")
	public Cart updateCart(@RequestBody Cart cart) throws CartException {
		try {
			this.cartService.updateCart(cart);
		} catch (CartException e) {
			e.getMessage();
		}
		return cart;
	}

	@DeleteMapping("cart/{id}")
	public void deleteCartById(@PathVariable("id") Integer cartId) throws CartException {
		try {
			cartService.deleteCartById(cartId);
		} catch (CartException e) {
			throw new CartException(e.getMessage());
		}
	}

}
