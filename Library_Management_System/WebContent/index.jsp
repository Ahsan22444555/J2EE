<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="Images/favicon.svg" type="image/x-icon">
    <link rel="stylesheet" href="css/login.css"/>
    <title>Login Page | LMS</title>
<body>
<div class="wrapper fadeInDown">
      <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Sign In </h2>
    
        <!-- Login Form -->
        <form action="Login" method="post">
          <input type="email" id="login" class="fadeIn second" name="login" placeholder="email" required>
          <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password" required >
          <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
        
      </div>
    </div>
</body>
</html>