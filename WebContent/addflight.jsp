<%@ page import="com.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<script src="js/addflightformvalidation.js"></script>
<title>Add a flight</title>
<script>
function myFunction() {
    var x = Date.parse(document.getElementById("DepartureTime").value);
    console.log(x);
    return x;
}
function myFunction2()
{
	var x = myFunction();
	var y = Date.parse(document.getElementById("ArrivalTime").value);
	console.log("x = "+x);
	console.log("y = "+y);
	console.log(x<y);
}
</script>
</head>
<body>
	<jsp:include page= "header.jsp"/>

	<div class="container">
		<hr>
		<form action="AddFlightServlet" name="addflightform" id="addflightform">

			<div class="form-group">
				<label for="FlightNO">FlightNO</label> <input type="text"
					name="FlightNO" class="form-control" id="FlightNO"
					placeholder="FlightNO">
			</div>
			<div class="form-group">
				<label for="SeatsNO">SeatsNo</label> <input type="text"
					name="SeatsNO" class="form-control" id="SeatsNO"
					placeholder="SeatsNO" >
			</div>
			<div class="form-group">
				<label for="DepartureTime">DepartureTime</label> <input
					type="datetime-local" name="DepartureTime" class="form-control"
					id="DepartureTime" placeholder="HH:MM" onblur="myFunction()">
			</div>
			<div class="form-group">
				<label for="DeparturePort">DeparturePort</label> <input
					type="text" name="DeparturePort" class="form-control"
					id="DeparturePort" placeholder="DeparturePort" >
			</div>
	
			<div class="form-group">
				<label for="ArrivalTime">ArrivalTime</label> <input
					type="datetime-local" name="ArrivalTime" class="form-control"
					id="ArrivalTime" placeholder="HH:MM" onblur="myFunction2()">
			</div>
			<div class="form-group">
				<label for="ArrivalPort">ArrivalPort</label> <input
					type="text" name="ArrivalPort" class="form-control"
					id="ArrivalPort" placeholder="ArrivalPort" >
			</div>
			<button type="submit" class="btn btn-success">Add</button>
			</form>
	</div>
</body>
</html>