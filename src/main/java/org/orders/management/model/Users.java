package org.orders.management.model;

public class Users {
	private int id;
	private String userName;
	private String userPassword;

	public Users() {
		super();
	}

	public Users(int id, String userName, String userPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}

}
