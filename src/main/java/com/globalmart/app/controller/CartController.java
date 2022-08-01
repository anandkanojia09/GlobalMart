package com.globalmart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.CartRepo;
import com.globalmart.app.dto.Cart;

@RestController
public class CartController {

	@Autowired
	private CartRepo cartRepo;

	@PostMapping("cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartRepo.save(cart);
	}

	@GetMapping("cart/{id}")
	public Optional<Cart> getCartById(@PathVariable("id") Integer cartId) {
		return cartRepo.findById(cartId);
	}

	@PostMapping("cart/update")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartRepo.save(cart);
	}

	@DeleteMapping("cart/delete")
	public void deleteCart(@RequestBody Cart cart) {
		cartRepo.delete(cart);
	}
}
