<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
  <%@include file="CSS/login.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="LoginServlet" method="post">

<div class="login-wrap">

	
	<div class="login-html">
	
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		
		<div class="login-form">
		
				<div class="sign-in-htm">
					<div class="group">
						<label for="user" class="label">Username</label>
						<input id="user" type="text" class="input" name="userName" required>
					</div>
					
					<div class="group">
						<label for="pass" class="label">Password</label>
						<input id="pass" type="password" class="input" data-type="password" name="password" required>
					</div>
					
					<div class="group">
						<input id="check" type="checkbox" class="check" checked>
						<label for="check"><span class="icon"></span> Keep me Signed in</label>
					</div>
					
					<div class="group">
						<input type="submit" class="button" value="Sign In" name="submit">
					</div>
					
					<div class="hr"></div>
					<div class="foot-lnk">
						<a href="#forgot">Forgot Password?</a>
					</div>
					
					<br>
					<div class="foot-lnk">
						<a href="registration.jsp">Sign up?</a>
					</div>	
					
					<br>	
					<br>
					<center>
						<a href="adminlogin.jsp"> <p style="color:#808080;">Admin Login</p></a>
					</center>
				
				</div>
			</div>
		</div>
	</div>
</form>

</body>
</html>