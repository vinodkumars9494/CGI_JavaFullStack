package org.orders.management;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.orders.management.config.SpringConfig;
import org.orders.management.model.Orders;
import org.orders.management.model.Users;
import org.orders.management.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserAutanticationAndOrderManagemnet {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

	OrdersService ordersService = context.getBean("ordersService", OrdersService.class);
	Scanner sc = new Scanner(System.in);

	int count = 0;

	public void userDetailsCheck(String userName, String userPassword) {

		try {

			List<Users> userInfo = ordersService.userInfoCheck(userName, userPassword);
			List<Users> list = userInfo.stream()
					.filter(s -> s.getUserName().equals(userName) && s.getUserPassword().equals(userPassword))
					.collect(Collectors.toList());
			if (list.isEmpty()) {
				count++;
				System.out.println("Invalid Credentails");
				if (count == 3) {
					System.out.println("Terminated from session due to many invaid credentail attempts");
				} else {
					inputReading();
				}
			} else {
				System.out.println("Login Success");
				operationOptionSelection();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public  void operationOptionSelection() {
		System.out.println("Please Select below option to perform opeartions");
		System.out.println("1.Get All Orders" + "\n" + "2.Find Orders by Id" + "\n" + "3.Create Order \n"
				+ "4.Find max order value" + "\n" + "5.Find min order value" + "\n" + "6.Delete all orders" + "\n"
				+ "7.Delete order by id" + "\n" + "8.Update order by Id" + "\n" + "9.Update order by name");
		System.out.println("Enter numeric option");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			getAllOrders();
			break;
		}
		case 2: {
			findOrderById();
			break;
		}
		case 3: {
			createOrder();
			break;
		}
		case 4: {
			MaxOrderByPrice();
			break;
		}
		case 5: {
			MinOrderByPrice();
			break;
		}
		case 6: {
			deleteAllOrders();
			break;
		}
		case 7: {
			deleteOrderById();
			break;
		}
		case 8: {
			updateOrderDetailsById();
			break;
		}
		case 9: {
			updateOrderDetailsByName();
			break;
		}
		default:
			System.out.println("Invalid option Selected");
		}
	}

	private void updateOrderDetailsByName() {
		System.out.println("Please enter name to update order detail");
		String orderName = sc.next();
		System.out.println("Order price");
		int orderPrice = sc.nextInt();
		ordersService.updateOrderDetailsByName(orderName,orderPrice);
	}

	private void updateOrderDetailsById() {
		System.out.println("Please enter id to update order detail");
		int orderId = sc.nextInt();
		System.out.println("Order Name");
		String orderName = sc.next();
		System.out.println("Order price");
		int orderPrice = sc.nextInt();
		Orders order = new Orders(orderId,orderName,orderPrice);
		ordersService.updateOrderDetailsById(order);
		
	}

	private void deleteOrderById() {
		System.out.println("Please Enter the order id to delete order details");
		int orderId = sc.nextInt();
		 ordersService.deleteOrderById(orderId);
		
	}

	private void deleteAllOrders() {
		ordersService.deleteAllOrders();
		
	}

	private void MinOrderByPrice() {
		Orders order = ordersService.getOrderByMinPrice();
		System.out.println(order);
		
	}

	private void MaxOrderByPrice() {
		
		Orders order = ordersService.getOrderByMaxPrice();
		System.out.println(order);
	}

	private void createOrder() {
		System.out.println("Please the order detail");
		System.out.println("Order Name");
		String orderName = sc.next();
		System.out.println("Order price");
		int orderPrice = sc.nextInt();
		ordersService.createOrder(orderName, orderPrice);
	}

	private void findOrderById() {
		System.out.println("Please Enter the order id to get details");
		int orderId = sc.nextInt();
		Orders orderDetails = ordersService.getOrderInfoById(orderId);

		if (!orderDetails.getOrderName().equals(null)) {
			System.out.println("Please find below order details for order id as " + orderId);
			System.out.println(orderDetails);
		} else {
			System.out.println("No Matching details found for order id");
		}

	}

	private void getAllOrders() {
		List<Orders> ordersList = ordersService.getAllOrders();
		for (Orders order : ordersList) {
			System.out.println(order);
		}

	}

	public void inputReading() {
		System.out.println("--------Enter Login details-------- ");
		System.out.print("Enter user name: ");
		String userName = sc.next();
		System.out.print("Enter user password: ");
		String userPassword = sc.next();
		userDetailsCheck(userName, userPassword);
	}


}
