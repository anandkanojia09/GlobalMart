package com.globalmart.app.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.OrdersRepo;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.dto.Order;
import com.globalmart.app.dto.Payment;
import com.globalmart.app.dto.Product;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.exception.OrderMartException;
import com.globalmart.app.exception.ProductException;

/************************************************************************************
 *         @author          Abhishek Yadav
 *         Description      It is the Business Logic implementation for the methods used in the
	                        controller class.
 *                          It is a service class that provides the operations for order class like add order, get order, 
 *          				delete order, update order.
 *         Version          1.1
 *         Created Date     08-AUG-2022
 ************************************************************************************/

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepo ordersRepo;
	
	@Autowired
	private ProductServicesInterface productServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	/************************************************************************************
	 * Method: getOrder
     * Description:  	fetches orders data from the application.
	 * @param id - id of the order to be searched.
	 * @returns order - container object of the fetched order class or throws exception.
	 * @throws OrderMartException - It is raised due to no details of the order to be fetched or wrong input.
     * Created By - Abhishek Yadav
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/

	public Optional<Order> getOrderById(Integer id) throws OrderMartException, SQLException {
		Optional<Order> orderD = ordersRepo.findById(id);
		if (orderD.isEmpty()) {
			throw new OrderMartException("User with order id " + id + " does not exist");
		}
		return orderD;
	}
	
	/************************************************************************************
	 * Method: addOrder
     * Description: add order(s) data for the application.
	 * @param order - order data of type Order class.
	 * @returns order - saved or added order class or throws exception.
	 * @throws OrderMartException - It is raised due to no details of the order to be added.
     * Created By - Abhishek Yadav
     * Created Date - 08-AUG-2022
	 ************************************************************************************/

	@Override
	public Order addOrder(Order order) throws OrderMartException, SQLException {
		if (order == null)
			throw new OrderMartException("Order cant be empty");
		ordersRepo.save(order);
		return order;
	}

	
	/************************************************************************************
	 * Method: deleteOrder
     * Description: delete order(s) data from the application.
	 * @param id - id of the order to be deleted.
	 * @returns boolean - true, if deleted successfully or throw exception.
	 * @throws OrderMartException - It is raised due to no details of the order to be added.
     * Created By - Abhishek Yadav
     * Created Date - 08-AUG-2022                          
	 ************************************************************************************/
	
	@Override
	public boolean deleteOrderById(Integer id) throws OrderMartException, SQLException {
		boolean deleteOrder = false;
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
	public List<Order> findAllOrders() throws OrderMartException, SQLException {
		List<Order> orderList = ordersRepo.findAll();
		if (orderList.isEmpty()) {
			throw new OrderMartException("No orders found!");
		}
		return orderList;
	}
	
	
	/************************************************************************************
	 * Method: updateOrder
     * Description: update order(s) data for the application.
	 * @param order - order data of type Order class.
	 * @returns order - updated order data class or throws exception.
	 * @throws OrderMartException - It is raised due to no details of the order or wrong input.
     * Created By - Abhishek Yadav
     * Created Date - 08-AUG-2022                           
	 ************************************************************************************/

	@Override
	public Order updateOrder(Order orders) throws OrderMartException, SQLException {
		if (orders == null) {
			throw new OrderMartException("Order cannot be null");
		}
		Optional<Order> foundOrder = this.ordersRepo.findById(orders.getOrderId());
		if (foundOrder.isEmpty()) {
			throw new OrderMartException("Order doesnot exists for id " + orders.getOrderId());
		}
		return this.ordersRepo.save(orders);
	}

	@Override
	public Order orderProduct(Integer productId, Integer customerId) throws ProductException, GlobalMartException, OrderMartException {
		Product product = productServices.getProductById(productId).get();
		Customer customer = customerServices.getCustomerById(customerId).get();
		List<Order> orders = customer.getOrders();
		Order order = new Order();
		List<Product> products = order.getProduct();
		products.add(product);
		order.setAmount(product.getOrderQuantity() * product.getPrice());
		order.setPayment(new Payment(1,null, order.getAmount(),"Success"));
		order.setProduct(products);
		customer.setOrders(orders);
		ordersRepo.save(order);
		customerServices.addCustomer(customer);
		return order;
	}

}
