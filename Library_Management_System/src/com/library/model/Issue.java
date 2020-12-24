package com.library.model;

public class Issue {
 protected int iid;
 protected int user_id;
 protected int bid;
 protected String book_name;
 protected String author;
 protected String datetime;
 protected String return_date;
 
 
 public Issue() {
		
 }

 public Issue(int iid, int user_id, int bid, String book_name, String author, String datetime, String return_date) {
 	super();
 	this.iid = iid;
 	this.user_id = user_id;
 	this.bid = bid;
 	this.book_name = book_name;
 	this.author = author;
 	this.datetime = datetime;
 	this.return_date = return_date;
 } 



public Issue(int iid, int user_id, int bid, String datetime, String return_date) {
	super();
	this.iid = iid;
	this.user_id = user_id;
	this.bid = bid;
	this.datetime = datetime;
	this.return_date = return_date;
}

public int getIid() {
	return iid;
}

public void setIid(int iid) {
	this.iid = iid;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getDatetime() {
	return datetime;
}

public void setDatetime(String datetime) {
	this.datetime = datetime;
}

public String getReturn_date() {
	return return_date;
}

public void setReturn_date(String return_date) {
	this.return_date = return_date;
}

public int getBid() {
	return bid;
}

public String getBook_name() {
	return book_name;
}

public void setBook_name(String book_name) {
	this.book_name = book_name;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public void setBid(int bid) {
	this.bid = bid;
}



}
