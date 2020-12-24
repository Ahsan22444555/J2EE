package com.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Dao.DBInerract;
import com.library.model.Account;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Account account;
    private DBInerract i;
    
    public void init() {
    	account = new Account();
    	i = new DBInerract();
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		account.setUser_name(request.getParameter("login"));
		account.setPassword(request.getParameter("pass"));
		
		try {
			if(i.loginValidate(account)) {
				System.out.print("Hello");
				response.sendRedirect("Welcome.jsp");
			}
			
			else {
				PrintWriter P = response.getWriter();
				System.out.print("Hello1");
				P.println("<H1> Email or Password is not Correct</H1> ");
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
