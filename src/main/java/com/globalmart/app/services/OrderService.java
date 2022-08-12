package com.globalmart.app.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Order;
import com.globalmart.app.exception.OrderMartException;

public interface OrderService {

	public Order addOrderById(Order order) throws OrderMartException,SQLException;

	public Optional<Order> getOrderById(Integer id) throws OrderMartException,SQLException ;

	boolean deleteOrderById(Integer id) throws OrderMartException,SQLException;

//	public Order save(Order orders);

	public List<Order> findAll() throws OrderMartException,SQLException;

 
	public Order updateOrder(Order orders) throws OrderMartException,SQLException;

}