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

import com.globalmart.app.dto.Admin;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.AdminServices;
import com.globalmart.app.services.CustomerServices;

/************************************************************************************
 *         @author          Anand Kumar Kanojia
 *         Description      It is a controller class that handles the HTTP requests for admin class 
 *         Version          1.1
 *         Created Date     08-AUG-2022
 ************************************************************************************/
@RestController
public class AdminController {

	@Autowired
	private CustomerServices customerServices;
	@Autowired
	private AdminServices adminServices;

	/************************************************************************************
	 * Method: addAdmin
     * Description: add admin(s) data for the application.
	 * @param admin - admin data of type Admin class.
	 * @returns admin - saved or added admin class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be added.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@PostMapping("admin/register")
	public Admin addAdmin(@Valid @RequestBody Admin admin) throws GlobalMartException {
		Admin adminAdded = null;
		adminAdded = adminServices.addAdmin(admin);
		return adminAdded;
	}

	/************************************************************************************
	 * Method: getAdmin
     * Description:  	fetches admin(s) data from the application.
	 * @param id - id of the admin to be searched.
	 * @returns admin - container object of the fetched admin class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be fetched or wrong input.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/
	@GetMapping("admin/{id}")
	public Optional<Admin> getAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		Optional<Admin> customerFound = null;
		customerFound = adminServices.getAdminById(id);
		return customerFound;
	}

	/************************************************************************************
	 * Method: updateAdmin
     * Description: update admin(s) data for the application.
	 * @param admin - admin data of type Admin class.
	 * @returns admin - updated admin data class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin or wrong input.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                           
	 ************************************************************************************/
	@PatchMapping("admin")
	public Admin updateAdmin(@RequestBody Admin admin) throws GlobalMartException {
		Admin adminUpdated = null;
		adminUpdated = adminServices.updateAdmin(admin);
		return adminUpdated;
	}
	
	/************************************************************************************
	 * Method: deleteAdmin
     * Description: delete admin(s) data from the application.
	 * @param id - id of the admin to be deleted.
	 * @returns boolean - true, if deleted successfully or throw exception.
	 * @throws GlobalMartException - It is raised due to no details of the admin to be added.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/
	@DeleteMapping("deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") Integer id) throws GlobalMartException {
		String msg = null;
		if (adminServices.deleteAdminById(id))
			msg = "Admin id " + id + " deleted Successfully";
		return msg;
	}

	/************************************************************************************
	 * Method: getAllCustomers
     * Description: fetches all the customer(s) data for the application.
	 * @returns List<admin> - List of customer(s) or throws exception.
	 * @throws GlobalMartException - It is raised if no customer data available.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                           
	 ************************************************************************************/
	@GetMapping("customers")
	public List<Customer> getAllCustomers() throws GlobalMartException {
		List<Customer> customers = null;
		customers = customerServices.getAllCustomers();
		return customers;
	}

	/************************************************************************************
	 * Method: getAllAdmin
     * Description: fetches all the admin(s) data for the application.
	 * @returns List<admin> - List of admin(s) or throws exception.
	 * @throws GlobalMartException - It is raised if no admin data available.
     * Created By - Anand Kumar Kanojia
     * Created Date - 08-AUG-2022                           
	 ************************************************************************************/
	@GetMapping("admins")
	public List<Admin> getAllAdmins() throws GlobalMartException {
		List<Admin> admins = null;
		admins = adminServices.getAllAdmins();
		return admins;
	}

}