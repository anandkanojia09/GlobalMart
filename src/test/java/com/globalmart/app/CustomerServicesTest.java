package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

	Customer customer = new Customer(18, "test", "pass1", "passtest", "test@mail.com", "89879987", "23", "cityTEST",
			"testState", 897876, null, null);

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
		assertNotNull(customerService.getCustomerById(18).get());
		Customer customer1 = customerService.getCustomerById(18).get();
		assertEquals("test", customer1.getCustomerName());
	}

	@Test
	void deleteCustomer() throws GlobalMartException {
		assumeTrue(customerService != null);
		assertThrows(GlobalMartException.class, () -> customerService.deleteCustomerById(8976));
		assertTrue(customerService.deleteCustomerById(18));
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
		assertThrows(GlobalMartException.class, () -> customerService.getCustomerByUserNameAndPassword(null, null));
		assertThrows(GlobalMartException.class,
				() -> customerService.getCustomerByUserNameAndPassword("ppppp", "pppp"));
		assertNotNull(customerService.getCustomerByUserNameAndPassword("passtest", "pass1"));

	}

	@Test
	void updateCustomer() throws GlobalMartException {
		assumeTrue(customerService != null);
		Customer customer1 = new Customer();
		assertThrows(Exception.class, () -> customerService.updateCustomer(null));
		assertThrows(GlobalMartException.class, () -> customerService.updateCustomer(new Customer(2233, "test", "pass1",
				"passtest", "test@mail.com", "89879987", "23", "cityTEST", "testState", 897876, null, null)));
		customer1 = new Customer(18, "TEST", "password", "passtest", "test@mail.com", "89879987", "23", "cityTEST",
				"testState", 897876, null, null);
		assertNotNull(customerService.updateCustomer(customer1));
		assertEquals("TEST", customer1.getCustomerName());

	}

}
