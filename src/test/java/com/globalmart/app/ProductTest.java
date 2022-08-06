package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.ProductServicesInterface;

@SpringBootTest
class ProductTest {

	@Autowired
	private ProductServicesInterface productService;

//	Product product = new Product();
	Category category = new Category(1, "categoryName", "categoryDescription");
//	Category category = new Category (1, "categoryName", "categoryDescription"));

	@Test
	void addProductByIdTest() throws ProductException {
		Product product = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
		productService.addProduct(product);
		assumeTrue(productService != null);
		assertNotNull(productService.getProductById(6));
	}

	@Test
	void getAllProducts() throws ProductException {
//	Product product = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
//		Product productnew = productService.addProduct(product);
		assumeTrue(productService != null);
		assertNotNull(productService.getAllProducts());
	}

	@Test
	void deleteProductByIdTest() throws ProductException {
		Product product = productService.getProductById(6).get();
		assumeTrue(productService != null);
		productService.deleteProductById(6);
//		assertNull(productService.getProductById(3).get());
//		assertNotNull(productService.getProductById(3).get());
		assertThrows(ProductException.class, () -> productService.getProductById(6));
		productService.addProduct(product);
	}

	@Test
	void deleteProductByIdTest2() throws ProductException {
//		Product product = productService.getProductById(6).get();
		assumeTrue(productService != null);
//		productService.deleteProductById(6);
//		assertNull(productService.getProductById(3).get());
//		assertNotNull(productService.getProductById(3).get());
		assertThrows(ProductException.class, () -> productService.deleteProductById(2506));
//		productService.addProduct(product);
	}

	@Test
	void deleteProductTest() throws ProductException {
		Product product = productService.getProductById(6).get();
		assumeTrue(productService != null);
		productService.deleteProduct(product);
//		assertNull(productService.getProductById(3).get());
//		assertNotNull(productService.getProductById(3).get());
		assertThrows(ProductException.class, () -> productService.getProductById(6));
		productService.addProduct(product);
	}

	@Test
	void updateProductTest() throws ProductException {
		Product myproduct = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
		Product product = new Product(6, "oldProduct", "MyDescription", 2500.00, 25, category);
		productService.addProduct(product);
		assumeTrue(productService != null);
		assertNotNull(productService.updateProduct(myproduct));
	}

	@Test
	void deleteProduct() throws ProductException {
		Product myproduct = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
		productService.addProduct(myproduct);
		assumeTrue(productService != null);
		productService.deleteProduct(myproduct);
		assertThrows(ProductException.class, () -> productService.getProductById(6));
	}

}
