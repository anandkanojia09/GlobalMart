package com.globalmart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.OrdersRepo;
import com.globalmart.app.dto.Order;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController {

	@Autowired
	private OrdersRepo ordersRepo;

	@PostMapping("orders")
	public Order addOrder(@RequestBody Order orders) {
		return ordersRepo.save(orders);
	}

	@GetMapping("orders/{id}")
	public Optional<Order> getProduct(@PathVariable("id") Integer id) {
		return ordersRepo.findById(id);
	}

	@PostMapping("orders/update")
	public Order updateProduct(@RequestBody Order orders) {
		return ordersRepo.save(orders);
	}

	@DeleteMapping("orders/delete/{id}")
	public void deleteOrders(@PathVariable("id") Integer id) {
		ordersRepo.deleteById(id);
	}

}
