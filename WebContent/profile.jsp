<%@page import="com.dao.CustomerDAO"%>
<%@page import="com.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<script src="js/profileformvalidation.js"></script>
<title>User info</title>
</head>
<body>
<jsp:include page= "header.jsp"/>

	<div class="container">
		<hr>
		<div class="container">
    <h1>Edit Profile</h1>
  	<hr>
	<div class="row">
      <!-- left column -->
      <div class="col-md-3">
        <div class="text-center">
          <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
          <h6>Upload a different photo...</h6>
          
          <input type="file" class="form-control">
        </div>
      </div>
      
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <div class="alert alert-info alert-dismissable">
          <a class="panel-close close" data-dismiss="alert">×</a> 
          <i class="fa fa-coffee"></i>
          <strong>Alert:</strong> Email address is your user name, which cannot be updated.
        </div>
        <h3>Personal info</h3>
        
        <form class="form-horizontal" role="form" action ="UpdateProfileServlet" id ="profileform">
          <div class="form-group">
            <label for = "fname" class="col-lg-3 control-label">First name:</label>
           <div class="col-lg-8">
              <input class="form-control" type="text" id="fname" name ="fname" value="<%=((Customer)session.getAttribute("cust")).getFname()%>" >
            </div>
          </div>
          <div class="form-group">
            <label for="lname" class="col-lg-3 control-label">Last name:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" id="lname" name = "lname" value="<%=((Customer)session.getAttribute("cust")).getLname()%>">
            </div>
          </div>
          <div class="form-group">
            <label for="address" class="col-lg-3 control-label">Address:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" id="address" name = "address" value="<%=((Customer)session.getAttribute("cust")).getAddress()%>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name = "uname" value="<%=((Customer)session.getAttribute("cust")).getEmail()%>" readonly>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Passport:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" value="<%=((Customer)session.getAttribute("cust")).getPassportNO()%>" readonly>
            </div>
          </div>
          <div class="form-group">
            <label  for ="dob" class="col-md-3 control-label">Date of Birth:</label>
            <div class="col-md-8">
              <input class="form-control" type="date" id = "dob" name = "dob" value="<%=((Customer)session.getAttribute("cust")).getDOB()%>" >
            </div>
          </div>
          <div class="form-group">
            <label for="phone" class="col-md-3 control-label">Phone Number:</label>
            <div class="col-md-8">
              <input class="form-control" type="text" id="phone" name = "phone" value="<%=((Customer)session.getAttribute("cust")).getPhone()%>" required>
            </div>
          </div>
          <div class="form-group">
            <label for="pword" class="col-md-3 control-label">Password:</label>
            <div class="col-md-8">
              <input class="form-control" type="text" id="pword" name = "pword" value="<%=CustomerDAO.getPassword(((Customer)session.getAttribute("cust")).getEmail())%>">
            </div>
          </div>
          <div class="form-group">
            <label for="pwrod1" class="col-md-3 control-label">Confirm password:</label>
            <div class="col-md-8">
              <input class="form-control" type="text" id="pword1" name = "pword1" value="<%=CustomerDAO.getPassword(((Customer)session.getAttribute("cust")).getEmail())%>">
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
          <div class="col-md-8">
              <input type="submit" class="btn btn-primary" value="Save">
              <a href = "profile.jsp"><input type="reset" class="btn btn-default" value="Cancel"></a>
          </div>
         </div>
        </form>
      </div>
  </div>
</div>
<hr>
	</div>
</body>
</html>