//bookflightform
//bookflightformvalidation.js
$(document).ready(function() 
{
	$.validator.addMethod('passportNO', function (value) { 
	    return  /^[A-PR-WYa-pr-wy][1-9]\d\s?\d{5}[1-9]$/.test(value); 
	}, 'Please enter a valid Passport Number.');
	
	$("#bookflightform").validate(
	{
		rules:
		{
			pfname:
			{
				required: true,
				nowhitespace: true,
				letterswithbasicpunc: true
			},
			plname:
			{
				required: true,
				nowhitespace: true,
				letterswithbasicpunc: true
			},
			ppassno:
			{
				required: true,
				passportNO:true
			},
			tclass:
			{
				required: true
			}
		},
		messages:
		{
			pfname:
			{
				required: "First name, please",
				nowhitespace: "No space allowed",
				letterswithbasicpunc: "Valid names only contain letters and basic punctuations"
			},
			plname:
			{
				required: "Last name, please",
				nowhitespace: "No space allowed",
				letterswithbasicpunc: "Valid names only contain letters and basic punctuations"
			},
			ppassno:
			{
				required: "Passport info is mandatory",
				passportNO: "Valid Passport only"
			},
			tclass:
			{
				required: "Please choose a ticke class"
			}
		},
		submitHandler: function(form) 
		{
			form.submit();
		}
	});// validate ends
}); //ready ends
