package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.ProductException;
import com.globalmart.app.services.ProductServicesInterface;

@SpringBootTest
@Transactional
class ProductTest {

	@Autowired
	ProductServicesInterface productService = Mockito.mock(ProductServicesInterface.class);

	Category category = new Category(1, "categoryName", "categoryDescription");

	@BeforeEach
	void starterScript() throws ProductException {
		productService.updateProduct(new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category));
	}

	@Test
	void addProductTest() throws ProductException {
		productService.deleteProductById(6);
		assertDoesNotThrow(
				() -> productService.addProduct(new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category)));
	}

	@Test
	void addProductTest2() throws ProductException {
		assertThrows(ProductException.class,
				() -> productService.addProduct(new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category)));
	}

	@Test
	void getProductByIdTest() throws ProductException {
		assertNotNull(productService.getProductById(6));
	}

	@Test
	void getProductByIdTest2() throws ProductException {
		assertThrows(ProductException.class, ()-> productService.getProductById(999));
	}

	@Test
	void getProductByNameTest() throws ProductException {
		assertNotNull(productService.getProductByName("MyProduct"));
	}

	@Test
	void getProductByNameTest2() throws ProductException {
		assertThrows(ProductException.class, () -> productService.getProductByName("NoProduct"));
	}

	@Test
	void getAllProducts() throws ProductException {
		productService.deleteProductById(6);
		assertDoesNotThrow(() -> productService.getAllProducts());
	}

	@Test
	void deleteProductByIdTest() throws ProductException {
		productService.deleteProductById(6);
		assertThrows(ProductException.class, () -> productService.getProductById(6));
	}

	@Test
	void deleteProductByIdTest2() throws ProductException {
		assertThrows(ProductException.class, () -> productService.deleteProductById(999));
	}

	@Test
	void deleteProductByNameTest() throws ProductException {
		this.addProductTest();
		assertEquals("Delete operation successful", productService.deleteByName("MyProduct"));
	}

	@Test
	void updateProductTest() throws ProductException {
		Product product = new Product(6, "UpdatedProduct", "MyDescription", 2500.00, 25, category);
		assertNotNull(productService.updateProduct(product));
	}

	@Test
	void updateProductTest2() throws ProductException {
		Product updatedProduct = new Product(6, "UpdatedProduct", "MyDescription", 2500.00, 25, category);
		assertEquals(updatedProduct, productService.updateProduct(updatedProduct));
	}

	@Test
	void deleteProduct() throws ProductException {
		Product myproduct = new Product(6, "MyProduct", "MyDescription", 2500.00, 25, category);
		productService.deleteProduct(myproduct);
		assertThrows(ProductException.class, () -> productService.getProductById(6));
	}
	

}
