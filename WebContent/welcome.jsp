<%@ page import="com.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css">
.jumbotron {
	color: #2c3e50;
	background-color: #ecf0f1;
}

.navbar-inverse {
	background: #2c3e50;
}

.navbar-inverse .navbar-nav>li>a {
	color: white;
}

.navbar-inverse .navbar-brand {
	color: white;
}
/* div 
		{ 
  		 	margin-bottom: 10px; 
  			position: relative; 
 		} 
 */
input[type="number"] {
	idth: 100px;
}

input+span {
	padding-right: 30px;
}

input:invalid+span:after {
	position: absolute;
	content: 'unchecked';
	padding-left: 5px;
	color: #8b0000;
}

input:valid+span:after {
	position: absolute;
	content: 'checked';
	padding-left: 5px;
	color: #009000;
}
</style>
<title>Congratulations!!!</title>

</head>

<body>
	<%-- <nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-nav-burger"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="index.jsp" class="navbar-brand"><span
				class="glyphicon glyphicon-plane" aria-hidden="true"></span> MY
				Airlines</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-nav-burger">
			<ul class="nav navbar-nav">
				<li><a href="#">About</a></li>
				<li><a href="#">Contact</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">
				<% Customer c = (Customer)session.getAttribute("cust");
					String name = c.getFname() +" "+ c.getLname();
				%>
				<%= name %>></a></li>

			</ul>
		</div>
	</div>
	</nav> --%>
	<jsp:include page= "header.jsp"/>

	<div class="container">
		<hr>

	<!-- <div class="container">
		<br>
		<div class="jumbotron">
			<p>Congratulations!!!</p>
			<p>You have successfully signed up!</p>
			<P>Please Log in.</P>
		</div> -->

		<form action="LoginServlet">
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
		<!-- </div> -->
</body>
</html>