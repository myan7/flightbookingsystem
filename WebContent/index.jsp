<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MY Airlines-Airline Tickets, Travel Deals and Flight</title>
</head>
<body>
	<jsp:include page= "header.jsp"/>

	<div class="container">
	<hr>
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" name="uname" class="form-control"
					id="exampleInputEmail1" placeholder="Email" required>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" name="pword" class="form-control"
					id="exampleInputPassword1" placeholder="Password" required>
			</div>
			<button type="submit" class="btn btn-default">Login</button>
		</form>
	</div>
</body>
</html>