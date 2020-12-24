<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
          <a href="Another?name=viewIssue">View Issued Books</a>
          <a href="issueBook.jsp">Issue Book</a>
          <a href="returnBook.jsp">Return Book</a>
          <a href="addUser.jsp">Add User</a>
          <a href="addBook.jsp">Add Book</a>
          <a class="active" href="#">Log Out</a>
        </div>
        
        <div class="content">
        <div class="card-body">
        <a href="index.jsp">Logout</a>
        </div>
        </div>
</body>
</html>