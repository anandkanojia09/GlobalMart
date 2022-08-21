package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.CustomerServices;

@SpringBootTest
class CustomerServicesTest {

	@Autowired
	CustomerServices customerService;
	@Autowired
	CustomerRepo customerRepo;

	Customer customer = new Customer(1, "Test", "Pass@123", "test1", "test@mail", "9090909090", "23", "testCity",
			"testState", "122312");

	@BeforeEach
	@Test
	void addCustomer() throws GlobalMartException {
		assumeTrue(customerService != null);
		assertThrows(GlobalMartException.class, () -> customerService.addCustomer(null));
		assertNotNull(customerService.addCustomer(customer));
	}

	@Test
	void getCustomer() throws GlobalMartException {
		assumeTrue(customerService != null);
		assertThrows(GlobalMartException.class, () -> customerService.getCustomerById(90));
		assertNotNull(customerService.getCustomerById(1).get());
		Customer customer1 = customerService.getCustomerById(1).get();
		assertEquals("Test", customer1.getCustomerName());
	}

	@Test
	void deleteCustomer() throws GlobalMartException {
		assumeTrue(customerService != null);
		assertThrows(GlobalMartException.class, () -> customerService.deleteCustomerById(8976));
		assertTrue(customerService.deleteCustomerById(1));
		customerService.addCustomer(customer);
	}

	@Test
	void allCustomers() throws GlobalMartException {
		assumeTrue(customerService != null);
		assertNotNull(customerService.getAllCustomers());
//		customerService.deleteCustomerById(18);
		customerRepo.deleteAll();
		assertThrows(GlobalMartException.class, () -> customerService.getAllCustomers());
	}

	@Test
	void getCustomerByNameAndPassword() throws GlobalMartException {
		assumeTrue(customerService != null);
		assertThrows(GlobalMartException.class, () -> customerService.getCustomerByUserNameAndUserPassword(null, null));
		assertThrows(GlobalMartException.class,
				() -> customerService.getCustomerByUserNameAndUserPassword("ppppp", "pppp"));
		assertNotNull(customerService.getCustomerByUserNameAndUserPassword("test1", "Pass@123"));

	}

	@Test 
	void updateCustomer() throws GlobalMartException {
		assumeTrue(customerService != null);
		Customer customer1 = new Customer();
		assertThrows(Exception.class, () -> customerService.updateCustomer(null));
		assertThrows(GlobalMartException.class, () -> customerService.updateCustomer(new Customer(1099, "Test",
				"pass@123", "test1", "test@mail", "9090909090", "23", "testCity", "testState", "122312")));
		customer1 = new Customer(1, "TEST", "Pass@123", "test1", "test@mail", "9090909090", "23", "testCity",
				"testState", "122312");
		assertNotNull(customerService.updateCustomer(customer1));
		assertEquals("TEST", customer1.getCustomerName());

	}

}
