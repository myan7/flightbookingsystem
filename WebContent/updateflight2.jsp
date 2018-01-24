<%@page import="com.bean.Customer"%>
<%@page import="com.bean.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Flight</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<script src="js/updateflightformvalidation.js"></script>
<style type="text/css">
	*[role="form"] {
    max-width: 530px;
    padding: 15px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 0.3em;
}

*[role="form"]{
    margin-left: 5em;
    margin-bottom: 1em;
}			
</style>
</head>
<body>
<jsp:include page= "header.jsp"/>
		
		<div class="container">
		<hr>

					<%
					Flight updflight = (Flight)request.getAttribute("updflight");
					 System.out.println(updflight.getArrivalTime());
					%>
					
			<form action="UpdateFlightServlet3" id="updateflightform" name="updateflightform" method="post">
			<div class="form-group">
				<label>Flight NO:</label> <%=updflight.getFlightNO()%> 
			</div>
			<div class="form-group">
				<label for="seatsNO">Number of Seats:</label> 
				<INPUT TYPE="text" class="form-control" id="seatsNO" NAME="seatsNO" VALUE=<%=updflight.getSeatsNO()%> >
			</div>
			<div class="form-group">
				<label for="dcity">Flying From:</label> 
				<INPUT TYPE="text"  class="form-control" id="dcity" NAME="dcity" VALUE=<%=updflight.getDepartureCity()%> >
			</div>
			
			<div class="form-group">
				<label for="dport">Departure Port:</label> 
				<INPUT TYPE="text"  class="form-control" id="dport" NAME="dport" VALUE=<%=updflight.getDeparturePort()%> >
			</div>
			
			<div class="form-group">
				<label for="dtime">Departure Time:</label> 
				<INPUT TYPE="datetime-local" id="dtime" class="form-control" NAME="dtime" VALUE=<%=updflight.getDepartureTime().replace(' ','T')%> >
			</div>
			
			<div class="form-group">
				<label for="acity">Flying To:</label> 
				<INPUT TYPE="text" id="acity" class="form-control" NAME="acity" VALUE=<%=updflight.getArrivalCity()%> >
			</div>
			
			<div class="form-group">
				<label for="aport">Arrival Port:</label> 
				<INPUT TYPE="text" id="aport" class="form-control" NAME="aport" VALUE=<%=updflight.getArrivalPort()%> >
			</div>	
			
			
			<div class="form-group">
				<label for="atime">Arrival Time:</label> 
				<INPUT TYPE="datetime-local" id="atime" class="form-control" NAME="atime" VALUE= <%=updflight.getArrivalTime().replace(' ','T')%> >
			</div>
			<input type="hidden" name="updId"  value="<%=updflight.getFlight_id()%>" />
			<input type="hidden" name="updNO"  value="<%=updflight.getFlightNO()%>" />	
			<button type="submit" class="btn btn-primary">update</button>
		</form>
</body>
</html>