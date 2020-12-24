package com.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Dao.DBInerract;
import com.library.model.Account;
import com.library.model.Books;
import com.library.model.Issue;

/**
 * Servlet implementation class Another
 */
@WebServlet("/Another")
public class Another extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBInerract i = new DBInerract();
    
   
    public Another() {
        super();
    }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
	
	    	String toDo = request.getParameter("name");
	    	
	    	if(toDo.equalsIgnoreCase("viewbook")) {
	    		viewBook(request, respons);
	    	}
	    	
	    	else if(toDo.equalsIgnoreCase("addbook")) {
	    		addBook(request, respons);
	    	}
	    	
	    	else if(toDo.equalsIgnoreCase("adduser")) {
	    		addUser(request, respons);
	    	}
	    	
	    	else if(toDo.equalsIgnoreCase("issuebook")) {
	    		issueBook(request, respons);
	    	}
	    	
	    	else if(toDo.equalsIgnoreCase("viewuser")) {
	    		viewUser(request, respons);
	    	}
	    	
	    	else if(toDo.equalsIgnoreCase("return")) {
	    		returnBook(request, respons);
	    	}
	    	
	    	else if(toDo.equalsIgnoreCase("viewissue")) {
	    		viewIssue(request, respons);
	    	}
	    
	}
	

	private void viewIssue(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
		List<Issue> user = i.viewIssue();
		request.setAttribute("issue", user);
		
		RequestDispatcher d = request.getRequestDispatcher("viewIssue.jsp");
		d.forward(request, respons);
	}

	private void returnBook(HttpServletRequest request, HttpServletResponse respons) throws IOException, ServletException {
		
		Issue ret = new Issue();
		ret.setUser_id(Integer.parseInt(request.getParameter("userid")));
		ret.setBid(Integer.parseInt(request.getParameter("bookname")));
		ret.setReturn_date(request.getParameter("returndate"));
		
		int result = i.retur(ret);
		
		RequestDispatcher d = request.getRequestDispatcher("returnBook.jsp");
		if(result != 0) {
			request.setAttribute("result", "Book Returned!");
		}
		
		else {
			request.setAttribute("result", "Either book is already returned or not present in library Book List.");
		}
		
		d.forward(request, respons);
	}

	private void issueBook(HttpServletRequest request, HttpServletResponse respons) throws IOException, ServletException {
		
		Issue b = new Issue();
		b.setUser_id(Integer.parseInt(request.getParameter("userid")));
		b.setBook_name(request.getParameter("bookname"));
		b.setAuthor(request.getParameter("author"));
		
		int result = i.issue(b);
		System.out.println(result+"Hello");
		RequestDispatcher d = request.getRequestDispatcher("issueBook.jsp");
		if(result != 0) {
			request.setAttribute("result", "Book Issued!");
		}
		
		else {
			request.setAttribute("result", "Currently Unavailable. Book is already Issued");
		}
		
		d.forward(request, respons);
	}

	private void viewUser(HttpServletRequest request, HttpServletResponse respons) throws ServletException, IOException {
		
        List<Account> user = i.viewUser();
		
		request.setAttribute("account", user);
		
		RequestDispatcher d = request.getRequestDispatcher("viewUsers.jsp");
		d.forward(request, respons);
	}

	private void addBook(HttpServletRequest request, HttpServletResponse respons) throws IOException, ServletException {
		
		Books b = new Books();
		b.setBname(request.getParameter("bname"));
		b.setAuthor(request.getParameter("author"));		
		int result = i.addBook(b);
		
		RequestDispatcher d = request.getRequestDispatcher("addBook.jsp");
		if(result != 0) {
			request.setAttribute("result", "Adding book Successfull");
		}
		
		else {
			request.setAttribute("result", "Book cannot be Added");
		}
		
		d.forward(request, respons);
		
	}

	private void viewBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Books> book = i.viewBook();
		
		request.setAttribute("book", book);
		
		RequestDispatcher d = request.getRequestDispatcher("Nadmin.jsp");
		d.forward(request, response);
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse respons) throws IOException, ServletException {
		
		Account b = new Account();
		b.setUser_name(request.getParameter("uname"));
		b.setPassword(request.getParameter("pass"));
		b.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		int result = i.addUser(b);
		
		RequestDispatcher d = request.getRequestDispatcher("addUser.jsp");
		if(result != 0) {
			request.setAttribute("result", "User Added!");
		}
		
		else {
			request.setAttribute("result", "Cannot add User");
		}
		
		d.forward(request, respons);
	}

}


