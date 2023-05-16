package org.orders.management.model;

import org.orders.management.UserAutanticationAndOrderManagemnet;

public class Orders {
	private int id;
	private String orderName;
	private int orderPrice;

	public Orders() {
		super();
	}

	public Orders(int id, String orderName, int orderPrice) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderName=" + orderName + ", orderPrice=" + orderPrice + "]";
	}

	public static void main(String[] args)
	
	{
		UserAutanticationAndOrderManagemnet user=new UserAutanticationAndOrderManagemnet();
		user.inputReading();
	
	}

}
