//profileformvalidation.js
$(document).ready(function() 
{
	$.validator.addMethod("pwcheck", function(value) {
		   return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // consists of only these
		       && /[a-z]/.test(value) // has a lowercase letter
		       && /\d/.test(value) // has a digit
		});

	$.validator.addMethod("minAge", function(value, element, min) {
	    var today = new Date();
	    var birthDate = new Date(value);
	    var age = today.getFullYear() - birthDate.getFullYear();
	 
	    if (age > min+1) {
	        return true;
	    }
	 
	    var m = today.getMonth() - birthDate.getMonth();
	 
	    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
	        age--;
	    }
	 
	    return age >= min;
	});
	$("#profileform").validate(
	{
		rules:{
			fname:{
				required: true
			},
			lname:{
				required: true
			},
			address:{
				required: true
			},
			dob:
			{
				required: true,
				minAge:16
			},
			phone:
			{
				required: true,
				phoneUS: true
			},
			pword: 
			{
				required: true,
				pwcheck: 8
			},
			pword1: 
			{
				required: true,
				equalTo: "#pword"
			}
		},
		messages:{
			fname: 
			{
				required: "First name, please",
				nowhitespace: "No space allowed",
				letterswithbasicpunc: "Valid names only contain letters and basic punctuations"
			},
			lname: 
			{
				required: "Last name, please",
				nowhitespace: "No space allowed",
				letterswithbasicpunc: "Valid names only contain letters and basic punctuations"
			},
			phone: 
			{
				required: "Please input your phone number and we will protect your privacy.",
				phoneUS:"Sorry, only phone numbers in the US are accepted"
			},
			dob:
			{
				required: "Please enter you date of birth.",
	            minAge: "Minimum age is 16"
			},
			address:
			{
	    			required: "You can edit later"
			},
			pword: 
			{
				required: "Please provide a password",
				pwcheck: "Strong password should contain at least one Uppercase, one Lowercase and one Digit, minimum length is 8"
			},
			pword1:
			{
				required: "Please re-enter the password above",
				equalTo: "Please enter the same password as above"
			}
		},
		submitHandler: function(form) 
		{
			form.submit();
		}
	});	

});