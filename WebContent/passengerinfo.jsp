<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<script src="js/bookflightformvalidation.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function checkClass(){
	if(bookflightform.tclass=="")
	{
		alert("You need to Choose a ticket class");	
		return false;
	}
	return true;
	}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
		<hr>
		<form action = "bookforself.jsp" method = "post">
			<button type = "submit" class="btn btn-default">Book for Yourself</button>
		</form>
		<form action="ConfirmBookServlet"  id="bookflightform" name="bookflightform" method="post">
		
			<div class="form-group">
				<label for="pfname">First Name</label> <input
					type="text" name="pfname" class="form-control"
					id="pfname" placeholder="First Name" >
			</div>
			<div class="form-group">
				<label for="plname">Last Name</label> <input type="text"
					name="plname" class="form-control" id="plname"
					placeholder="Last Name" >
			</div>
			<div class="form-group">
				<label for="ppassno">Passport Number</label> <input
					type="text" name="ppassno" class="form-control"
					id="ppassno" placeholder="Passport Number"
					>
			</div>

			<div class="form-group">
				<label for="tclass">Class</label> 
					<select name="tclass" id="tclass">
					 	<option></option>
	  					<option value="First Class">First Class</option>
					  	<option value="Business Class">Business Class</option>
					  	<option value="Economy Class">Economy Class</option>
					</select>
			</div>
			<button type="submit" class="btn btn-default" onclick="return checkClass();">Submit</button>
		</form>
	</div>
</body>
</html>