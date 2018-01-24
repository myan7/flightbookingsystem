<%@page import="com.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/additional-methods.js"></script>
<script src="js/searchflightformvalidation.js"></script>
<title>Welcome!</title>
</head>
<body>
 <jsp:include page= "header.jsp"/>
	<div class="container" >
		<hr>
        <div >
            <form class = "form-inline" method="get" action="SearchFlightServlet" id="serchflightform">
            
	            <div class="form-group">
	            <label for="from">Leaving from:
	            		<input id="from" name="from" class="form-control" type="text"  placeholder="City name" >
	            		</label>
	            </div>
	            
	            <div class="form-group">
	            		<label for="to">Going to:
	            		<input id="to" name="to" class="form-control" type="text"  placeholder="City name">
	            		</label>
	            </div>
	            
	            <div class="form-group">
	            <label for="on">Departing on:
	            		<input id="on" name="on" class="form-control" type="date"  placeholder="">
	            		</label>
	            </div>
	            
	            <div class = "form-group" >
	                <button type="submit" class="btn btn-primary"><i class="icon-search icon-white">Search</i></button>
	            </div>
	            
            </form>
        </div>
	</div>

</body>
</html>