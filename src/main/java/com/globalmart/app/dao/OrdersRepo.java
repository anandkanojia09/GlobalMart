package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmart.app.dto.Order;

public interface OrdersRepo extends JpaRepository<Order, Integer> {

	/************************************************************************************
	 * @author Abhishek Yadav
	 * 
	 *         Description : It is a OrderRepo class that extends Jpa Repository
	 *         interface it provides all the functions to perform crud operations on
	 *         the database and much more.
	 * 
	 *         Version 1.1
	 * 
	 *         Created Date 08-AUG-2022
	 ************************************************************************************/
}
