package com.globalmart.app;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.globalmart.app.dto.Order;
import com.globalmart.app.exception.OrderMartException;
import com.globalmart.app.services.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderTest {

	@Autowired
	private OrderService orderService;

	@Test
	void getOrderByIdTest() throws OrderMartException, SQLException {
		assumeTrue(orderService != null);
//	 OrderService.getOrderById(7);
		// assert(OrderService.getOrderById(7).get());
		assertThrows(OrderMartException.class, () -> orderService.getOrderById(0));
		Order order = orderService.getOrderById(1).get();
		assertEquals(1, order.getOrderId());

	}

	@Test
	void addOrderByIdTest() throws OrderMartException {

		assumeTrue(orderService != null);

//		 Order order= new Order(30,"MyOrder","MyDescription",3000.00,21,category);

//		Order order = orderService.addOrder(null);
		 assertThrows(Exception.class,()-> orderService.addOrderById(null));

	}
	private void assumeTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void deleteOrderByIdTest() throws OrderMartException, SQLException{
 		assertEquals("Successful", this.orderService.deleteOrderById(1));
		assertThrows(OrderMartException.class,()-> this.orderService.deleteOrderById(500));
	}
//	@Test
//
//	public void updateOrderByIdTest() throws OrderMartException{
// 		assertNotNull(orderService.addOrderById());
// 		assertNotNull(orderService.updateOrder(order));
// 		assertThrows(OrderMartException.class,()-> this.orderService.updateOrderById(null));
//	}
	}
	
	


