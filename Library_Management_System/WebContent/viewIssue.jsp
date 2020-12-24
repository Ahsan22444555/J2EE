<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="Images/favicon.svg" type="image/x-icon" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/admin.css" />
    <title>Admin | LMS</title>
</head>
<body>
	<div class="sidebar">
	<a href="Welcome.jsp"> Welcome! </a>
          <a href="Another?name=viewBook">View Books</a>
          <a href="Another?name=viewUser">View Users</a>
          <a class="active" href="#">View Issued Books</a>
          <a href="issueBook.jsp">Issue Book</a>
          <a href="returnBook.jsp">Return Book</a>
          <a href="addUser.jsp">Add User</a>
          <a href="addBook.jsp">Add Book</a>
          <a href="logOut.jsp">Log Out</a>
        </div>
        
        <div class="content">
        
        <table class="table">
        <tr>
      		 <th scope="col">Issue Id</th>
      		 <th scope="col">User Id</th>
      		 <th scope="col">Book Id</th>
      		 <th scope="col">Issue Date</th>
      		 <th scope="col">Return Date</th>
      		 </tr>
      		<C:forEach var="user" items="${issue}">
      		 <tr>
      		 <td>${user.iid}</td>
      		 <td>${user.user_id}</td>
      		 <td>${user.bid}</td>
      		 <td>${user.datetime}</td>
      		 <td>${user.return_date}</td>
      		 </tr>       		 
      		</C:forEach>
      	</table>
        </div>
</body>
</html>