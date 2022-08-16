package com.globalmart.app.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.ProductServicesInterface;

@RestController
public class ProductController {
	/************************************************************************************
	 * @author Anant Narayan Patel
	 * 
	 *         Description : It is a REST controller class for adding, deleting and
	 *         updating new accounts. It also provides api to search and delete
	 *         product by name.
	 * 
	 *         Version 1.0
	 * 
	 *         Created Date 02-AUG-2022
	 ************************************************************************************/

	@Autowired
	private ProductServicesInterface productService;

	@PostMapping("product")
	public String addProduct(@Valid @RequestBody Product product) throws ProductException {
		/************************************************************************************
		 * Method: addProduct
		 * Description: To add a Product to Database.
		 * 
		 * @param productId          - Product Id
		 * @param productName        - Product Name
		 * @param productQuantity    - Product Quantity
		 * @param productPrice       - Product Price
		 * @param productDescription - Product Description
		 * @returns Product object if product added successfully else throws Exception.
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return productService.addProduct(product);
	}

	@GetMapping("product/{id}")
	public Product getProduct(@PathVariable("id") Integer id) throws ProductException {
		/************************************************************************************
		 * Method: getProduct
		 * Description: To get a Product from Database.
		 * 
		 * @param productId - Product Id
		 * @returns Product object if product found successfully else throws exception.
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return productService.getProductById(id).get();
	}

	@GetMapping("product")
	public List<Product> getByName(@Valid @RequestParam(value = "name") String name) throws ProductException {
		/************************************************************************************
		 * Method: getByName
		 * Description: To get all Products from Database by Name as query.
		 * 
		 * @param productName - Product Name
		 * @returns List of Products product matches search query else throws exception.
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return productService.getProductByName(name);
	}

	@GetMapping("products")
	public List<Product> getAllProducts() throws ProductException {
		/************************************************************************************
		 * Method: getAllProducts
		 * Description: To get all Products from Database as a List.
		 * 
		 * @returns List of Products if product is present, else throws exception.
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return productService.getAllProducts();
	}

	@PutMapping("product")
	public String updateProduct(@Valid @RequestBody Product product) throws ProductException {
		/************************************************************************************
		 * Method: updateProduct
		 * Description: To update a Product to Database, if already exists.
		 * 
		 * @param productId          - Product Id
		 * @param productName        - Product Name
		 * @param productQuantity    - Product Quantity
		 * @param productPrice       - Product Price
		 * @param productDescription - Product Description
		 * @returns Product object if product updated successfully else throws
		 *          Exception.
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return productService.updateProduct(product);
	}

	@DeleteMapping("product/{productId}")
	public String deleteProductById(@PathVariable(value = "productId") Integer productId) throws ProductException {
		/************************************************************************************
		 * Method: deleteProductById
		 * Description: To Delete a Product from Database by ID.
		 * 
		 * @param productId - Product Id
		 * @returns successful message string if delete is successful else throws
		 *          message.
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return (productService.deleteProductById(productId));
	}

	@DeleteMapping("products/{name}")
	public String deleteByNames(@PathVariable(value = "name") String name) throws ProductException {
		/************************************************************************************
		 * Method: deleteByName
		 * Description: To delete all Products from Database by Name as query.
		 * 
		 * @param productName - Product Name
		 * @returns successful message string if delete is successful else throws
		 *          ProductException
		 * @throws ProductException
		 * 
		 *                          Created By - Anant Narayan Patel
		 *                          Created Date - 7-AUG-2022
		 * 
		 ************************************************************************************/
		return productService.deleteByName(name);
	}
}
