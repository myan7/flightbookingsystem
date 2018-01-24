<%@page import="com.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MY Airlines-Airline Tickets, Travel Deals and Flight</title>
<link rel="stylesheet" type="text/css" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.error{
	color: red;
}
.jumbotron {
	color: #2c3e50;
	background-color;
	opacity:0.8;
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
body{
opacity:0.7;
}
</style>
</head>
<body background="a380.jpeg">
		<% 
			Customer c = (Customer)session.getAttribute("cust");
			if(c == null)
		{%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container" style="filter:alpha(opacity=50); opacity:0.5;">
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
					<li><a href="signup.jsp">Sign up</a></li>
					<li><a href="index.jsp">Log in</a></li>
				</ul>
			</div>
		</div>
	</nav>
		<% }
		else if(c.getUser_id()<10)
		{
			%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-nav-burger"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="adminhome.jsp" class="navbar-brand"><span
				class="glyphicon glyphicon-plane" aria-hidden="true"></span> MY
				Airlines</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-nav-burger">
			<ul class="nav navbar-nav">
				<li role="presentation"  id = "add" ><a href="addflight.jsp">Add
					Flight</a></li>
				<li role="presentation" id = "get"><a href="GetFlightServlet">View All
					Flight</a></li>
				<li role="presentation" id = "del"><a href="Pre_DeleteFlightServlet">Delete
					Flight</a></li>
				<li role="presentation" id = "update"><a href="UpdateFlightServlet">Update
					Flight</a></li>
				<li role="presentation" id = "update"><a href="GetTicketServlet">View Booked
					Flight</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href = "profile.jsp"> <% 
					String name = c.getFname()+ " "+c.getLname();
					%>Welcome, <%= name %> !
					</a></li>
				<li><a href="LogoutServlet">Log out</a></li>
			</ul>
		</div>
	</div>
	</nav>
			<% 
		}
		else
		{
			%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-nav-burger"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="userhome.jsp" class="navbar-brand"><span
					class="glyphicon glyphicon-plane" aria-hidden="true"></span> MY
					Airlines</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-nav-burger">
				<ul class="nav navbar-nav">
					<li role="presentation" id="search"><a href="userhome.jsp">Search</a></li>
					<li role="presentation" id="view"><a href="ViewHistoryServlet">View History</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href ="profile.jsp"> <% 
						String name = c.getFname()+ " "+c.getLname();
						%>Welcome, <%= name %> !
					</a></li>
					<li><a href="LogoutServlet">Log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
		<%	
		}
		%>
	
	
	<div class="container">
		<div class="jumbotron">
			<%
		if(request.getAttribute("msg")!= null)
		{
			String msg = (String)request.getAttribute("msg");
		%>
		<font color="red" size="4"><%= msg %></font>
		<%
		}
		%>
		</div> 
	</div>

</body>
</html>