<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Join us!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<script src="js/signupformvalidation.js"></script>

<!-- <style type="text/css">
.error{
	color: red;
}
.jumbotron {
	color: #2c3e50;
	opacity: 0;
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

</style> -->
<script type="text/javascript">
function checkAgree(){
	if(signupform.agree.checked == false)
	{
		alert("You need to agree to the terms");	
		return false;
	}
	return true;
	}
</script>
</head>
<body>
	<jsp:include page ="header.jsp"/>
	<div class="container">
	<hr>
		<form action="SignupServlet"  id="signupform" name ="signupform" method="post"  style="display: inline;">
			<div class="form-group">
				<label for="fname">First Name</label> 
				<input type="text" id="fname" name="fname" class="form-control required"
					 placeholder="First Name"/>
			</div>
			
			<div class="form-group">
				<label for="lname">Last Name</label> 
				<input type="text" id="lname" name="lname" class="form-control required" 
					placeholder="Last Name"/>
			</div>
			
			 <div class="form-group">
				<label for="email">Email address</label> <input
					type="email" id="uname" name="uname" class="form-control required email"
					 placeholder="Email"/>
			</div>
			
			<div class="form-group">
				<label for="passport">Passport Number</label> <input
					type="text" name="passport" class="form-control"
					id="passport" placeholder="Passport Number" /> 
			</div>
			
			<div class="form-group">
				<label for="phone">Telephone Number</label> 
				<input type="text" name="phone"
					class="form-control" id="phone"
					 /> 
			</div>
			
			<div class="form-group">
				<label for="dob">Date of Birth</label> 
				<input type="date" name="dob" class="form-control"
					id="dob" placeholder="MM/DD/YYYY"/>
			</div>
			
			<div class="form-group">
				<label for="address">Address</label> <input
					type="text" name="address" class="form-control"
					id="address" placeholder="address"/>
			</div>
			
			<div class="form-group">
				<label for="pword">Password</label> <input
					type="password" name="pword" class="form-control"
					id="pword" placeholder="Password" required/>
			</div>
			
			<div class="form-group">
				<label for="pword1">Confirm Your Password</label> <input
					type="password" name="pword1" class="form-control"
					id="pword1" placeholder="Comfirm Your Password"
					title="Please enter the same Password as above" required/>
			</div>
			<input type="checkbox" name ="agree", id="agree" > I agree
					with the terms and conditions
			<div>
			<button type="submit" class="btn btn-default" onclick="return checkAgree();">Sign up</button>
			</div>
		</form>
	</div>
</body>
</html>