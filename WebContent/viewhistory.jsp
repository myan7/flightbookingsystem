<%@page import="com.bean.Ticket"%>
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
					<td align="center">Action</td>
				</tr>
			</thead>
			<tbody>
			<%
					ArrayList<Ticket> history = (ArrayList<Ticket>)session.getAttribute("history");
				for(Ticket t: history)
				{
					%>
				<tr>
					<form action = "CancelReservationServlet"> 
					<td name="flightid" align="center"><%= t.getFlight().getFlightNO() %></td>
					<td align="center"><%= t.getFlight().getDepartureCity() %></td>
					<td align="center"><%= t.getFlight().getDepartureTime().substring(0,16) %></td>
					<td align="center"><%= t.getFlight().getArrivalCity() %></td>
					<td align="center"><%=t.getFlight().getArrivalTime().substring(0,16) %></td>
					<td align="center"><%= t.getPfname()+" "+t.getPlname() %></td>
					<td align="center"><%= t.getTicket_class() %></td>
					<td align="center"><%= t.getTicket_status() %></td>
					<% if(t.getTicket_status().equals("booked"))
					{
					%>
						<td><button align="center" type="submit" class="btn btn-danger">Cancel</button></td>
					<% 
					}
					%>
					<input type="hidden" name="fid" value="<%=t.getFlight_id() %>" />
					<input type="hidden" name="tid" value="<%= t.getTicket_id() %>" />
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