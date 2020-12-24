package com.library.model;

public class Books {
int bid;
String bname;
String author;
int issued_or_not;
boolean issue;

public Books(int bid, String bname, String author, boolean issue) {
	super();
	this.bid = bid;
	this.bname = bname;
	this.author = author;
	this.issue=issue;
}

public boolean isIssue() {
	return issue;
}

public void setIssue(boolean issue) {
	this.issue = issue;
}

public Books() {
	
}

public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

public int getIssued_or_not() {
	return issued_or_not;
}

public void setIssued_or_not(int issued_or_not) {
	this.issued_or_not = issued_or_not;
}

public void setBid(int bid) {
	this.bid = bid;
}

public int getBid() {
	return bid;
}

}
