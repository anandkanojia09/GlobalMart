package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.globalmart.app.dao.ProductRepo;
import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.ProductServicesInterface;

@SpringBootTest
@Transactional
class ProductTest {

	@Autowired
	ProductServicesInterface productService = Mockito.mock(ProductServicesInterface.class);
	@Autowired
	private ProductRepo productRepo;

	Category category = new Category(1, "categoryName", "categoryDescription");

	@BeforeEach
	void starterScript() throws ProductException {
		productRepo.save(new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category));
	}

	@Test
	void addProductTest() throws ProductException {
		productService.deleteProductById(6);
		Product product = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
		assertDoesNotThrow( () -> productService.addProduct(product));
	}

	@Test
	void addProductTestMore() throws ProductException {
		Product product = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
		assertThrowsExactly(ProductException.class, ()->productService.addProduct(product), "Product with ID 6 is already present in Database.");
	}

	@Test
	void getProductByIdTest() throws ProductException {
		assertNotNull(productService.getProductById(6));
		assertThrows(ProductException.class, () -> productService.getProductById(999));
	}

	@Test
	void getProductByNameTest() throws ProductException {
		assertNotNull(productService.getProductByName("MyProduct"));
		assertThrows(ProductException.class, () -> productService.getProductByName("NoProduct"));
	}

	@Test
	void getAllProducts() throws ProductException {
		assertDoesNotThrow(() -> productService.getAllProducts());
		productRepo.deleteAll();
		productRepo.flush();
		assertThrows(ProductException.class, ()-> productService.getAllProducts());
	}

	@Test
	void deleteProductByIdTest() throws ProductException {
		assertEquals("Product With ID 6 Deleted Successfully.", productService.deleteProductById(6));
		assertThrowsExactly(ProductException.class, ()->productService.deleteProductById(999), "No product with id 999 found.");
	}

	@Test
	void deleteProductByNameTest() throws ProductException {
		assertEquals("Delete operation successful", productService.deleteByName("MyProduct"));
		assertThrowsExactly(ProductException.class, ()->productService.deleteByName("MyProduct"), "No product with name MyProduct not found");
	}

	@Test
	void updateProductTest() throws ProductException {
		Product updatedProduct = new Product(6, "UpdatedProduct", "MyDescription", 2500.00, 25, category);
		assertNotNull(productService.updateProduct(updatedProduct));
		assertEquals(updatedProduct.toString(), productService.updateProduct(updatedProduct));
	}
	@Test
	void updateProductTestMore() throws ProductException {
		Product updatedProduct = new Product(999, "UpdatedProduct", "MyDescription", 2500.00, 25, category);
		assertThrowsExactly(ProductException.class, ()->productService.updateProduct(updatedProduct), "Product not found in Database, can't Update.");
	}
}
