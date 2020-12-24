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
          <a class="active" href="#">View Books</a>
          <a href="Another?name=viewUser">View Users</a>
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
      		 <th scope="col">Book Id</th>
      		 <th scope="col">Book Name</th>
      		 <th scope="col">Author</th>
      		 <th scope="col">Issued or Not</th>
      		 </tr>
      		<C:forEach var="book" items="${book}">
      		 <tr>
      		 <td>${book.bid}</td>
      		 <td>${book.bname}</td>
      		 <td>${book.author}</td>
      		 <td>
      		 <C:if test="${book.issue}">
      		 	Issued
      		 </C:if>
      		 
      		 <C:if test="${not book.issue}">
      		 	Not Issued
      		 </C:if>
      		 </td>
      	</tr>       		 
      		</C:forEach>
      	</table>
        </div>
</body>
</html>