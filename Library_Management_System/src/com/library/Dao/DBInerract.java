package com.library.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.connection.ConnectDB;
import com.library.model.Account;
import com.library.model.Books;
import com.library.model.Issue;

public class DBInerract {
	 Connection con;
	 
	 public DBInerract() {
		 ConnectDB A = new ConnectDB();
		 con = A.connection();
	 }
 
      public void addAccount(Account account) {
		try {
		
			String query = "insert into account(user_name, password, admin) values (?,?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString( 1, account.getUser_name());
			preparedStatement.setString( 2, account.getPassword());
			preparedStatement.setInt( 3, account.getAdmin() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println("Hello Server Y");
			e.printStackTrace();
		}
      }
      
      public int addBook(Books Book) {
    	  int result = 0;
  		try {
  		
  			String query = "insert into books(bname, author ) values (?,?)";
  			PreparedStatement preparedStatement = con.prepareStatement(query);
  			preparedStatement.setString( 1, Book.getBname().concat(" ").replaceAll("\\s", "@,"));
  			preparedStatement.setString( 2, Book.getAuthor().concat(" ").replaceAll("\\s", "@,"));
  			result = preparedStatement.executeUpdate();
  			preparedStatement.close();
  		} catch (Exception e) {
  			System.out.println("Hello Server");
  			e.printStackTrace();
  		}
		return result;
  	}

public boolean loginValidate(Account account) {
	boolean bool = false;
	try {
     String query = "Select * from account where user_name = ? and password = ? "; 
     System.out.println(account.getUser_name() + "  " + account.getPassword());
     PreparedStatement preparedStatement = con.prepareStatement(query);
     preparedStatement.setString(1, account.getUser_name());
     preparedStatement.setString(2, account.getPassword());
     ResultSet r = preparedStatement.executeQuery();
     bool = r.next();
     

} catch (SQLException e) {
    e.printStackTrace();
}
return bool;
}

public List<Books> viewBook() {
	List<Books> book = new ArrayList<>();
	try {
     String query = "Select * from books"; 
     Statement statement = con.createStatement();
     ResultSet r = statement.executeQuery(query);
     while(r.next()) {
    	 int bid = r.getInt("bid");
    	 String bname = r.getString("bname").replaceAll("@,", " ");
    	 String author = r.getString("author").replaceAll("@,"," ");
    	 int price = r.getInt("issued_or_not");
    	 boolean issue = price==1?true:false;
    	 Books b = new Books(bid, bname, author, issue);
    	 book.add(b);
     }

} catch (SQLException e) {
    e.printStackTrace();
}
	return book;
}

public List<Account> viewUser() {
	List<Account> user = new ArrayList<>();
	try {
     String query = "Select * from account"; 
     Statement statement = con.createStatement();
     ResultSet r = statement.executeQuery(query);
     while(r.next()) {
    	 int bid = r.getInt("user_id");
    	 String bname = r.getString("user_name");
    	 String author = r.getString("creation_date");
    	 int price = r.getInt("admin");
    	 boolean ad = price==1?true:false;
    	 Account b = new Account (bid, bname, author, ad);
    	 user.add(b);
     }

} catch (SQLException e) {
    e.printStackTrace();
}
	return user;
}

public int addUser(Account b) {
	  int result = 0;
	try {
  		
			String query = "insert into account(user_name, password, admin) values (?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString( 1, b.getUser_name() );
			preparedStatement.setString( 2, b.getPassword());
			preparedStatement.setInt( 3, b.getAdmin());
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println("Hello Server");
			e.printStackTrace();
			 
}
	
	return result;
}

public int issue(Issue b) {
	int result = 0;
	try {
  		
			String bid = "Select bid, issued_or_not from books where bname=? and author=?";
			PreparedStatement preparedStatement = con.prepareStatement(bid);
			String S1 = b.getBook_name().concat(" ");
			preparedStatement.setString( 1, S1.replaceAll("\\s", "@,"));
			S1 = b.getAuthor().concat(" ");
			preparedStatement.setString( 2, S1.replaceAll("\\s", "@,"));
			System.out.println(b.getAuthor().concat(" ").replaceAll("\\s", "@,"));
   	        ResultSet S = preparedStatement.executeQuery();
   	        System.out.println("Hello world Java");
   	        S.next();
   	     System.out.println("Hello world Java!");
   	        int id = S.getInt("bid");
   	        System.out.println(id);
   	        int Q=S.getInt("issued_or_not");
   	        System.out.print(Q+"     Dekho");
   	        if(Q==1) {
   	        	return 0;
   	        }
   	     System.out.println("Hello world Java2!");
   	        System.out.println(id);
			String query = "insert into issued (user_id, bid) values (?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt( 1, b.getUser_id());
			preparedStatement.setInt( 2, id);
			result = preparedStatement.executeUpdate();
			preparedStatement = con.prepareStatement("update books set issued_or_not=? where bid=?");
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println("Hello Server");
			e.printStackTrace();
			 
}
	
	return result;
}

public int retur(Issue ret) {
	
	int result = 0;
	try {
  			String query = "Update issued set return_date=? where user_id=? and bid=? and return_date is null";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, ret.getReturn_date());
			preparedStatement.setInt(2, ret.getUser_id());
			preparedStatement.setInt(3, ret.getBid());
			result = preparedStatement.executeUpdate();
			preparedStatement = con.prepareStatement("update books set issued_or_not=false where bid=?");
			preparedStatement.setInt(1, ret.getBid());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println("Hello Server");
			e.printStackTrace();
		}
	return result;
}

public List<Issue> viewIssue() {
	List<Issue> user = new ArrayList<>();
	try {
     String query = "Select * from Issued"; 
     Statement statement = con.createStatement();
     ResultSet r = statement.executeQuery(query);
     while(r.next()) {
    	 int iid = r.getInt("iid");
    	 int uid = r.getInt("user_id");
    	 int bid = r.getInt("bid");
    	 String i_date = r.getString("issue_date");
    	 String r_date = r.getString("return_date");
    	 Issue b = new Issue(iid, uid, bid, i_date, r_date);
    	 user.add(b);
     }

} catch (SQLException e) {
    e.printStackTrace();
}
	return user;
}
}
	
	
	
	
	
	
	
	
