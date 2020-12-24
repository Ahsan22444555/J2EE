package com.library.model;

public class Account {

private int user_id;
private String user_name;
private String password;
private String datetime;
private int admin;
private boolean admin1;

public Account() {
	super();
}

public Account(int user_id, String user_name, String datetime, boolean admin1) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.datetime = datetime;
	this.admin1=admin1;
}

public boolean isAdmin1() {
	return admin1;
}

public void setAdmin1(boolean admin1) {
	this.admin1 = admin1;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public void setDatetime(String datetime) {
	this.datetime = datetime;
}

public int getAdmin() {
	return admin;
}

public void setAdmin(int admin) {
	this.admin = admin;
}
public int getUser_id() {
	return user_id;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_name() {
	return user_name;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDatetime() {
	return datetime;
}
public String getPassword() {
	return password;
}

}
