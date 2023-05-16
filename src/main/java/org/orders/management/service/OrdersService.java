package org.orders.management.service;

import java.util.List;

import org.orders.management.model.Orders;
import org.orders.management.model.Users;

public interface OrdersService {

	public List<Users> userInfoCheck(String userName, String userPassword);

	public List<Orders> getAllOrders();

	public Orders getOrderInfoById(int orderId);

	public void createOrder(String orderName, int orderPrice);

	public Orders getOrderByMaxPrice();

	public Orders getOrderByMinPrice();

	public void deleteAllOrders();

	public void deleteOrderById(int orderId);

	public void updateOrderDetailsById(Orders order);

	public void updateOrderDetailsByName(String orderName, int orderPrice);
}
