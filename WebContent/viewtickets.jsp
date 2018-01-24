<%@page import="com.bean.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All Tickets</title>
</head>
<body>
<jsp:include page= "header.jsp"/>
	<div class="container">
		
		<hr>
		<div class="table-responsive">
		<table class="table table-hover" >
			<thead>
				<tr class="active">
					<td align="center">Flight NO</td>
					<td align="center">Flying From</td>
					<td align="center">Departure Time</td>
					<td align="center">Flying To</td>
					<td align="center">Arrival Time</td>
					<td align="center">Passenger Name</td>
					<td align="center">Class Info</td>
					<td align="center">Booking Status</td>
				</tr>
			</thead>
			<tbody>
			<%
					ArrayList<Ticket> tList = (ArrayList<Ticket>)session.getAttribute("tList");
				for(Ticket t: tList)
				{
					%>
				<tr>

					<td name="flightid" align="center"><%= t.getFlight().getFlightNO() %></td>
					<td align="center"><%= t.getFlight().getDepartureCity() %></td>
					<td align="center"><%= t.getFlight().getDepartureTime().substring(0,16) %></td>
					<td align="center"><%= t.getFlight().getArrivalCity() %></td>
					<td align="center"><%=t.getFlight().getArrivalTime().substring(0,16) %></td>
					<td align="center"><%= t.getPfname()+" "+t.getPlname() %></td>
					<td align="center"><%= t.getTicket_class() %></td>
					<td align="center"><%= t.getTicket_status() %></td>
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