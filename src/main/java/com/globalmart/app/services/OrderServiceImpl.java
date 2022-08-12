package com.globalmart.app.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.OrdersRepo;
import com.globalmart.app.dto.Order;
import com.globalmart.app.exception.OrderMartException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepo ordersRepo;

	public Optional<Order> getOrderById(Integer id) throws OrderMartException ,SQLException {
		Optional<Order> orderD = ordersRepo.findById(id);
		if (orderD.isEmpty()) {
			throw new OrderMartException("User with order id " + id + " does not exist");
		}
		return orderD;
	}

	@Override
	public Order addOrderById(Order order) throws OrderMartException ,SQLException {
		if (order == null)
			throw new OrderMartException("Order cant be empty");
		ordersRepo.save(order);
		return order;
	}
	 
	@Override
	public boolean deleteOrderById(Integer id) throws OrderMartException ,SQLException {
		boolean deleteOrder=false;
		if (ordersRepo.existsById(id)) {
			ordersRepo.deleteById(id);
			if (ordersRepo.existsById(id)) {
				throw new OrderMartException("User not deleted");
				
			}
			deleteOrder = true;
		} else {
			throw new OrderMartException("No Order with id " + id + " exists to be deleted ");
		}
		return deleteOrder;
	}

	@Override
	public List<Order> findAll() throws OrderMartException ,SQLException  {
		List<Order> orderList = ordersRepo.findAll();
		if (orderList.isEmpty()) {
			throw new OrderMartException("No orders found!");
		}
		return orderList;
	}

	 

	@Override
	public Order updateOrder(Order orders) throws OrderMartException ,SQLException  {
		if (orders == null) {
			throw new OrderMartException("Order cannot be null");
		}
		Optional<Order> foundOrder = this.ordersRepo.findById(orders.getOrderId());
		if (foundOrder.isEmpty()) {
			throw new OrderMartException("Order doesnot exists for id " + orders.getOrderId());
		}
		return this.ordersRepo.save(orders);
	}

}

//	@Override
//	public Order save(Order orders) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	