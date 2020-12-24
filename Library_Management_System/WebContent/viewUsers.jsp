<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="Images/favicon.svg" type="image/x-icon" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="css/admin.css" />
    <title>Admin | LMS</title>
</head>
<body>
<div class="sidebar">
<a href="Welcome.jsp"> Welcome! </a>
          <a href="Another?name=viewBook">View Books</a>
          <a class="active" href="#">View Users</a>
          <a href="Another?name=viewIssue">View Issued Books</a>
          <a href="issueBook.jsp">Issue Book</a>
          <a href="returnBook.jsp">Return Book</a>
          <a href="addUser.jsp">Add User</a>
          <a href="addBook.jsp">Add Book</a>
          <a href="logOut.jsp">Log Out</a>
        </div>
       
       <div class="content">
        <table class="table">
        <tr>
      		 <th scope="col">User Id</th>
      		 <th scope="col">User Name</th>
      		 <th scope="col">Creation date</th>
      		 <th scope="col">Admin/User</th>
      		 </tr>
      		<C:forEach var="user" items="${account}">
      		 <tr>
      		 <td>${user.user_id}</td>
      		 <td>${user.user_name}</td>
      		 <td>${user.datetime}</td>
      		 <td>
      		 <C:if test="${user.admin1}">
      		 Admin
      		 </C:if>
      		 <C:if test="${not user.admin1}">
      		 User
      		 </C:if>
      		 </td>
      		 </tr>       		 
      		</C:forEach>
      	</table>
       </div>
        
</body>
</html>