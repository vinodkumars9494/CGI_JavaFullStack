package org.orders.management.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.orders.management.model.Orders;
import org.orders.management.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ordersDao")
public class OrdersDaoImpl implements OrdersDao {

	private final DataSource dataSource;

	@Autowired
	public OrdersDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public List<Users> userInfoCheck(String userName, String userPassword) {
		List<Users> usersInfo = new ArrayList<Users>();
		List<Users> list;
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
			while (resultSet.next()) {
				usersInfo.add(new Users(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usersInfo;
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> ordersList = new ArrayList<Orders>();
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				ordersList.add(new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ordersList;
	}

	@Override
	public Orders getOrderInfoById(int orderId) {

		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders where id=" + orderId);
			while (resultSet.next()) {
				return new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new Orders();
	}

	@Override
	public void createOrder(String orderName, int orderPrice) {
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			boolean resultSet = statement.execute(" insert into hr.orders (orderName,orderPrice) values(" + "'"
					+ orderName + "'" + "," + orderPrice + ")");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public Orders getOrderByMaxPrice() {

		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hr.orders order by orderPrice desc limit 0,1");
			while (resultSet.next()) {
				return new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new Orders();
	}

	@Override
	public Orders getOrderByMinPrice() {

		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from hr.orders order by orderPrice  limit 0,1");
			while (resultSet.next()) {
				return new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new Orders();
	}

	@Override
	public void deleteAllOrders() {
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("delete from hr.orders");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrderById(int orderId) {
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("delete from orders where id=" + orderId);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrderById(Orders order) {
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders where id=" + order.getId());
			while (resultSet.next()) {
				Orders orderDetails = new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
				if (orderDetails.getOrderName() != null) {
					boolean resultSet1 = statement.execute("update hr.orders set orderName='+" + order.getOrderName()
							+ "',orderPrice=" + order.getOrderPrice() + "where id=" + order.getId());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void updateOrderDetailsByName(String orderName, int orderPrice) {
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders where orderName=" + orderName);
			while (resultSet.next()) {
				Orders orderDetails = new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
				if (orderDetails.getOrderName() != null) {
					boolean resultSet1 = statement
							.execute("update hr.orders set orderPrice=" + orderPrice + "where orderName=" + orderName);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
