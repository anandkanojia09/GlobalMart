package com.globalmart.app;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Category;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.CategoryException;
import com.globalmart.app.service.CustomerDetailsServices;

@SpringBootTest
public class CustomerDetailsTest {
	
	@Autowired
	CustomerDetailsServices customerDetailsServices;
  
	@Test
	public void testGetCustomerById() throws CategoryException {
		Assumptions.assumeTrue(customerDetailsServices != null);
		Optional<CustomerDetails> customer = customerDetailsServices.getCustomer(2);
		Assertions.assertTrue(customer.isPresent());
		Assertions.assertEquals(2, customer.get().getId());
		Assertions.assertThrows(CategoryException.class,()->this.customerDetailsServices.getCustomer(1000));
		
		
	}
	@Test
	public void testDeleteCustomer() throws CategoryException {
		Assumptions.assumeTrue(customerDetailsServices != null);
		   Optional<CustomerDetails> customerDetails = customerDetailsServices.getCustomer(2);
		Assertions.assertEquals(true,customerDetailsServices.deleteCustomer(2));
		Assertions.assertThrows(CategoryException.class,()->this.customerDetailsServices.deleteCustomer(1000));
		customerDetailsServices.addCustomer(customerDetails.get());
		
	}
	
	
	
}
