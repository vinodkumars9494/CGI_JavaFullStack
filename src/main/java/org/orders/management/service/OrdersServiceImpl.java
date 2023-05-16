package org.orders.management.service;

import java.util.List;

import org.orders.management.dao.OrdersDao;
import org.orders.management.model.Orders;
import org.orders.management.model.Users;
import org.springframework.stereotype.Component;
@Component("ordersService")
public class OrdersServiceImpl implements OrdersService {

	private final OrdersDao ordersDao;

	public OrdersServiceImpl(OrdersDao ordersDao) {

		this.ordersDao = ordersDao;
	}

	@Override
	public List<Users> userInfoCheck(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return ordersDao.userInfoCheck(userName, userPassword);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return ordersDao.getAllOrders();
	}

	@Override
	public Orders getOrderInfoById(int orderId) {
		return ordersDao.getOrderInfoById(orderId);

	}

	@Override
	public void createOrder(String orderName, int orderPrice) {
		ordersDao.createOrder(orderName, orderPrice);

	}

	@Override
	public Orders getOrderByMaxPrice() {
		// TODO Auto-generated method stub
		return ordersDao.getOrderByMaxPrice();
	}

	@Override
	public Orders getOrderByMinPrice() {
		// TODO Auto-generated method stub
		return ordersDao.getOrderByMinPrice();
	}

	@Override
	public void deleteAllOrders() {
		ordersDao.deleteAllOrders();

	}

	@Override
	public void deleteOrderById(int orderId) {
		ordersDao.deleteOrderById(orderId);

	}

	@Override
	public void updateOrderDetailsById(Orders order) {
		ordersDao.deleteOrderById(order);

	}

	@Override
	public void updateOrderDetailsByName(String orderName, int orderPrice) {
		ordersDao.updateOrderDetailsByName(orderName, orderPrice);

	}

}
