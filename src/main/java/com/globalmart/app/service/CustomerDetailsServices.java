package com.globalmart.app.service;

import java.util.List;
import java.util.Optional;



import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.CategoryException;

public interface CustomerDetailsServices {
     
	public CustomerDetails addCustomer(CustomerDetails customer);
	public Optional<CustomerDetails> getCustomer(Integer id) throws CategoryException;
	public Boolean deleteCustomer(Integer id)throws CategoryException;
	public CustomerDetails updateCustomer(CustomerDetails customer) throws CategoryException;
	public List<CustomerDetails> getAllCustomerDetals();
	
	
}
