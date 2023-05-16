package org.orders.management.dao;

import java.util.List;

import org.orders.management.model.Orders;
import org.orders.management.model.Users;

public interface OrdersDao {
	
	

	public List<Users> userInfoCheck(String userName,String userPassword);

	public List<Orders> getAllOrders();

	public Orders getOrderInfoById(int orderId);

	public void createOrder(String orderName, int orderPrice);

	public Orders getOrderByMaxPrice();

	public Orders getOrderByMinPrice();

	public void deleteAllOrders();

	public void deleteOrderById(int orderId);

	public void deleteOrderById(Orders order);

	public void updateOrderDetailsByName(String orderName, int orderPrice);

}
