package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CartRepo;
import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Cart;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.CartException;
import com.globalmart.app.exception.ProductException;

/************************************************************************************
 * @author Abhishek Kumar Jaiswal Description - It is a service implementation
 *         class that provides the services for adding a new cart, get cart
 *         details by cart id ,update the cart , delete the cart , add product
 *         to cart and remove product from cart.
 * 
 *         Created Date - 02-AUG-2022
 ************************************************************************************/

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductServicesInterface productService;

	/************************************************************************************
	 * Method: addCart Description: To add/create a new Cart
	 * 
	 * @param cart - Cart details of new cart
	 * @returns Cart - Cart added or created otherwise throws CartException
	 * @throws CartException - It is raised due to when cart is null or when user
	 *                       add a cart with id which is already used.
	 * 
	 *                       Created By - Abhishek Kumar Jaiswal Created Date -
	 *                       2-AUG-2022
	 * 
	 ************************************************************************************/

	@Override
	public Cart addCart(Cart cart) throws CartException {
		if (cart == null) {
			throw new CartException("please provide cart details to add.");
		}

		Optional<Cart> cart2 = cartRepo.findById(cart.getCartId());
		if (cart2.isPresent()) {
			throw new CartException("Cart is already exist with this id :");
		} else {
			return this.cartRepo.save(cart);
		}

	}

	/************************************************************************************
	 * Method: getCartById Description: For getting details of a Cart by its Id.
	 * 
	 * @param id - cartID of Cart.
	 * @returns cart - return the details of Cart otherwise throws CartException
	 * @throws CartException - It is raised due to when No Cart available related to
	 *                       that cartId or no cart exist related to id. . Created
	 *                       By - Abhishek Kumar Jaiswal Created Date - 2-AUG-2022
	 * 
	 ************************************************************************************/

	@Override
	public Optional<Cart> getCartById(Integer id) throws CartException {

		Optional<Cart> cart = cartRepo.findById(id);
		if (cart.isEmpty()) {
			throw new CartException("Cart with the id " + id + " is not exist.");
		}

		return cart;
	}

	/************************************************************************************
	 * Method: updateCart Description: To update the details of a Cart
	 * 
	 * @param cart - Cart details which is going to updated.
	 * @returns Cart - Return the updated vaule of Cart otherwise throws
	 *          CartException
	 * @throws CartException - It is raised due to when cart is null or when cart
	 *                       details is not related to any Cart.
	 * 
	 *                       Created By - Abhishek Kumar Jaiswal Created Date -
	 *                       2-AUG-2022
	 * 
	 ************************************************************************************/
	@Override
	public Cart updateCart(Cart cart) throws CartException {

		if (cart == null) {
			throw new CartException("provide data for update. ");
		}
		int x = cart.getCartId();
		if (cartRepo.existsById(x)) {
			cart = cartRepo.save(cart);

		} else {
			throw new CartException("No Cart is present as per given credentials.");
		}

		return cart;
	}

	/************************************************************************************
	 * Method: deleteCartById Description: To add/create a new Cart
	 * 
	 * @param id - Id of that Cart which is going to deleted.
	 * @returns Boolean - true if Cart deleted otherwise throws CartException.
	 * @throws CartException - It is raised due to when there is no cart available
	 *                       related to that id.
	 * 
	 *                       Created By - Abhishek Kumar Jaiswal Created Date -
	 *                       2-AUG-2022
	 * 
	 ************************************************************************************/

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

	/************************************************************************************
	 * Method: addProductToCart Description: To add a product into a Cart
	 * 
	 * @param cartId     - cart id of the Cart
	 * @param productId- product id of the Product
	 * @returns Cart - Cart with added product otherwise throws CartException
	 * @throws CartException    - It is raised due to when cart is null or when user
	 *                          add a cart with id which is not exist. Created By -
	 *                          Abhishek Kumar Jaiswal Created Date - 2-AUG-2022
	 * @throws ProductException
	 * 
	 ************************************************************************************/
	@Override
	public Cart addProductToCart(Integer id, Integer productId) throws CartException, ProductException {
		Integer quantity = 1;
		Cart cart = getCartById(id).get();
		Product product = productService.getProductById(productId).get();
		List<Product> productList = cart.getProducts();
		if (productList.contains(product)) {
			throw new CartException("Item already in Cart. Go to Cart!!");
		} else {

			product.setOrderQuantity(quantity);
			product.setProductQuantity(product.getProductQuantity() - quantity);
			productList.add(product);
			this.cartRepo.save(cart);
		}
		return cart;
	}

	/************************************************************************************
	 * Method: removeProductfromCart Description: To remove a product from a Cart
	 * 
	 * @param cartId     - cart id of the Cart
	 * @param productId- product id of the Product
	 * @returns Cart - Cart, after removed product otherwise throws CartException
	 * @throws CartException - It is raised due to when cart is null or when user
	 *                       add a cart with id which is not exist. Created By -
	 *                       Abhishek Kumar Jaiswal Created Date - 2-AUG-2022
	 * 
	 ************************************************************************************/

	@Override
	public Cart removeProductFromCart(Integer id, Integer productId) throws CartException, ProductException {
		Cart cart = getCartById(id).get();
		Product product = productService.getProductById(productId).get();
		List<Product> productList = cart.getProducts();
		if (productList.contains(product)) {
			Integer quantity = product.getOrderQuantity();
			productList.remove(product);
			product.setProductQuantity(product.getProductQuantity() + quantity);
			this.cartRepo.save(cart);
			productRepo.save(product);
		} else {
				throw new CartException("item is not present in Cart.");
		}
		return cart;
	}

	@Override
	public Cart updateProductQuantity(Integer id, Integer productId, Integer quantity) throws CartException, ProductException {
		Cart cart = getCartById(id).get();
		Product product = productService.getProductById(productId).get();
		List<Product> productList = cart.getProducts();
		if (productList.contains(product)) {
			if (quantity > product.getProductQuantity()) {
				throw new CartException("Quantity cannot be more than " + product.getProductQuantity()
						+ ". Please select quantity in range!! ");
			}
			product.setOrderQuantity(quantity+product.getOrderQuantity());
			product.setProductQuantity(product.getProductQuantity() - quantity);
			this.cartRepo.save(cart);
		} else
			throw new CartException("Internal error. Try again later!!");
		return cart;
	}

}
