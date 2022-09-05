package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.CustomerServices;

/************************************************************************************
 * @author 		Anand Kumar Kanojia 
 * Description  It is a service class that provides
 *         		the operations for customer class like register customer, get customer,
 *        		delete customer, update customer 
 * Version 		1.1 
 * Created Date 08-AUG-2022
 ************************************************************************************/
@RestController
public class CustomerController {

	@Autowired
	private CustomerServices customerService;

	/************************************************************************************
	 * Method: addCustomer 
	 * Description: add customer(s) data for the application.
	 * @param customer - customer data of type customer class.
	 * @returns customer - saved or added customer class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be added.
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@PostMapping("customer/register")
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws GlobalMartException {
		Customer customerAdded = null;	
		customerAdded = customerService.addCustomer(customer);
		return customerAdded;
	}

	/************************************************************************************
	 * Method: getCustomer
	 * Description: fetches customer(s) data from the application.
	 * @param id - id of the customer to be searched.
	 * @returns customer - container object of the fetched customer class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be fetched or wrong input. 
	 * Created By - AnandKumar Kanojia 
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@GetMapping("customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") Integer id) throws GlobalMartException {
		Optional<Customer> customerFound = null;
		customerFound = customerService.getCustomerById(id);
		return customerFound;
	}

	/************************************************************************************
	 * Method: getCustomerByUserName
	 * Description: fetches customer(s) data from the application.
	 * @param userName - id of the customer to be searched.
	 * @returns customer - container object of the fetched customer class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be fetched or wrong input. 
	 * Created By - AnandKumar Kanojia 
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@GetMapping("user/{userName}")
	public List<Customer> getCustomerByUserName(@PathVariable("userName") String userName) throws GlobalMartException {
		List<Customer> customerFound = null;
		customerFound = customerService.getCustomerByUserName(userName);
		return customerFound;
	}
	
	/************************************************************************************
	 * Method: updateCustomer 
	 * Description: update customer(s) data for the application.
	 * @param customer - customer data of type customer class.
	 * @returns customer - updated customer data class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer or wrong input. 
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@PatchMapping("customer")
	public Customer updateCustomer(@RequestBody Customer customer) throws GlobalMartException {
		Customer customerUpdated = null;
		customerUpdated = customerService.updateCustomer(customer);
		return customerUpdated;
	}

	/************************************************************************************
	 * Method: deleteCustomerById 
	 * Description: delete customer(s) data from the application.
	 * @param id - id of the customer to be deleted.
	 * @returns boolean - true, if deleted successfully or throw exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be added. 
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@DeleteMapping("customer/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer id) throws GlobalMartException {
		String msg = null;
		if (customerService.deleteCustomerById(id))
			msg = "Delete Successfull";
		return msg;
	}

}