<%@page import="com.bean.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "header.jsp"/>
	<div>
		<hr>
		<div class="table-responsive">
		<table class="table table-hover" >
			<thead>
				<tr class="active">
					<!-- <td align="center">Flight Id</td> -->
					<td align="center">Flight NO</td>
					<td align="center">Remaining Seats</td>
					<td align="center">Flying From</td>
					<td align="center">Departure Time</td>
					<td align="center">Flying To</td>
					<td align="center">Arrival Time</td>
					<td align="center">Action</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<%
					ArrayList<Flight> flightList = (ArrayList<Flight>)session.getAttribute("flightList");
				for(Flight f: flightList)
				{
					%>
					<form action = "BookFlightServlet" method="post"> 
					<td align="center"><%= f.getFlightNO() %></td>
					<td align="center"><%= f.getSeatsNO() %></td>
					<td align="center"><%= f.getDepartureCity() %></td>
					<td align="center"><%= f.getDepartureTime().substring(0,16) %></td>
					<td align="center"><%= f.getArrivalCity() %></td>
					<td align="center"><%= f.getArrivalTime().substring(0,16) %></td>
					<td align="center"><input type='submit' value='select'></td>
					<td><input type = "hidden" name= "id" value = <%= f.getFlight_id()%>></td>
					</form>
				</tr>
				<%
				}
				%>
			</tbody>
			</table>
			</div>
	</div>
</body>
</html>