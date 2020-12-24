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
          <a class="active" href="#">Add Book</a>
          <a href="logOut.jsp">Log Out</a>
        </div>
        
        <div class="content">
        <form action= "Another" method="get">
          <input type="hidden" name="name" value="addBook">
          
          <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">Book name</label>
    <div class="col-sm-10">
      <input type="text" id="book" class="form-control" name="bname" required>
    </div>
  </div>
  
  
  <div class="row mb-3">
    <label for="author" class="col-sm-2 col-form-label">Author</label>
    <div class="col-sm-10">
      <input type="text" id="author" class="form-control" name="author" required>
    </div>
  </div>  
  <button type="submit" class="btn btn-primary">Add Book!</button>          
          
        </form>
        <br><br>
        <C:forEach var="result" items="${result}">
        <div class="alert alert-success" role="alert">
  <h4 class="alert-heading">${result}</h4>
</div>        
     
          
     
        </C:forEach> 
        
        </div>
        
</body>
</html>