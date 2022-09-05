package com.globalmart.app.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Order;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.exception.OrderMartException;
import com.globalmart.app.exception.ProductException;

public interface OrderService {

	public Order addOrder(Order order) throws OrderMartException, SQLException;

	public Optional<Order> getOrderById(Integer id) throws OrderMartException, SQLException;

	boolean deleteOrderById(Integer id) throws OrderMartException, SQLException;

	public List<Order> findAllOrders() throws OrderMartException, SQLException;

	public Order updateOrder(Order orders) throws OrderMartException, SQLException;

	public Order orderProduct(Integer productId, Integer customerId)throws ProductException, GlobalMartException, OrderMartException;

}