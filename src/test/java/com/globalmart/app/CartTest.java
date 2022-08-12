package com.globalmart.app;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Cart;
import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.CartException;
import com.globalmart.app.service.CartService;

@SpringBootTest
public class CartTest {

	@Autowired
	private CartService cartService;

	@Test
	public void deleteCartByIdTest() throws CartException {
		Assumptions.assumeTrue(cartService != null);
		Cart cart = cartService.getCartById(1).get();
		cartService.deleteCartById(1);
		Assertions.assertThrows(CartException.class, () -> cartService.getCartById(1));
		cartService.addCart(cart);

	}

	@Test
	public void deleteCartByIdTest2() throws CartException {
		Assumptions.assumeTrue(cartService != null);

		Assertions.assertThrows(CartException.class, () -> cartService.deleteCartById(45));

	}

	@Test
	public void getCartByIdTest() throws CartException {
		Assumptions.assumeTrue(cartService != null);
		Cart cart = cartService.getCartById(1).get();
		Assertions.assertEquals(1, cart.getCartId());

	}

	@Test
	public void updateCartTest() throws CartException {

		Assumptions.assumeTrue(cartService != null);
		Cart cart = cartService.getCartById(6).get();
		// cartService.updateCart(cart).setCartPrice(1020.0);
		// cartService.updateCart(cart).setProductQuantity(1000);
		cart.setCartPrice(1000.0);
		cart.setProductQuantity(1000);
		cartService.updateCart(cart);
		// Cart cart2 = cartService.getCartById(6).get();
		Assertions.assertEquals(1000.0, cart.getCartPrice());
		Assertions.assertEquals(1000, cart.getProductQuantity());

	}

	@Test
	public void updateCartTest2() throws CartException {
		Assumptions.assumeTrue(cartService != null);
		Cart cart = null;
		Assertions.assertThrows(CartException.class, () -> cartService.updateCart(cart));

	}

	@Test
	public void updateCartTest3() throws CartException {
		Category category = new Category(10, "string10", "string10");
		List<Product> product = new ArrayList<>();
		product.add(new Product(12, "product12", "mastProduct", 120.0, 20, category));

		Cart newcart = new Cart(120, 10, 10.0, product);
		Assumptions.assumeTrue(cartService != null);
		Assertions.assertThrows(CartException.class, () -> cartService.updateCart(newcart));

	}

//	@Test
//	public void addCartTet() throws CartException {
//
//		Category category = new Category(10, "string10", "string10");
//		List<Product> product = new ArrayList<>();
//		product.add(new Product(12, "product12", "mastProduct", 120.0, 20, category));
//
//		Cart newcart = new Cart(11, 10, 10.0, product);
//		Assumptions.assumeTrue(cartService != null);
//		cartService.addCart(newcart);
//		//Assumptions.assumeTrue(cartService != null);
//		//Cart cartDetails = cartService.getCartById(10).get();
//		//Assertions.assertEquals(10, cartDetails.getCartId());
//		//Assertions.assertEquals(10.0, cartDetails.getCartPrice());
//
//	}
	@Test
	public void addCartTest3() throws CartException {

		Category category = new Category(10, "string10", "string10");
		List<Product> product = new ArrayList<>();
		product.add(new Product(12, "product12", "mastProduct", 120.0, 20, category));

		Cart newcart = new Cart(11, 10, 10.0, product);
		Assumptions.assumeTrue(cartService != null);
		Assertions.assertThrows(CartException.class, () -> cartService.addCart(newcart));
	}

	@Test
	public void addcartTest2() throws CartException {

		// Cart cart = new Cart(null,null,null,null);
		Cart cart = null;
		Assumptions.assumeTrue(cartService != null);
		Assertions.assertThrows(CartException.class, () -> cartService.addCart(cart));

	}

}
