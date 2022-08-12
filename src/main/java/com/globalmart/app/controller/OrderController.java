package com.globalmart.app.controller;

import java.sql.SQLException;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Order;
import com.globalmart.app.exception.OrderMartException;
import com.globalmart.app.services.OrderService;



@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("orders")
	public Order addOrder(@Valid @RequestBody Order orders) throws MethodArgumentNotValidException,  OrderMartException ,SQLException{
		return orderService.addOrderById(orders);
	}

	@GetMapping("orders/{id}")
	public Optional<Order> getOrder(@PathVariable("id") Integer id) throws OrderMartException,SQLException {
		return orderService.getOrderById(id);
	}
  
	@GetMapping("orders/all")
	public List<Order> getAllOrder() throws OrderMartException,SQLException{
		return orderService.findAll();
	}
	@PostMapping("orders/update")
	public Order updateOrder(@RequestBody Order orders)throws OrderMartException,SQLException {
		return orderService.updateOrder(orders);
	}

	@DeleteMapping("orders/delete/{id}")
	public String deleteOrders(@PathVariable("id") Integer id) throws OrderMartException,SQLException {
		String result ="";
		if( orderService.deleteOrderById(id)) {
			result = "delete successful";
		}
		return result;
	}

}