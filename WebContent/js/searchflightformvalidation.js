//searchflightformvalidation.js
$(document).ready(function(){
	$("#serchflightform").validate({
		rules:
		{
			from: 
			{
				required: true
			},
			to:
			{
				required:true
			}
			
		},
		messages:
		{
			from: 
			{
				required: "Origin city is required"
			},
			to:
			{
				required:"Destination city is required"
			}
		},
		submitHandler: function(form) 
		{
			form.submit();
		}
	});//validate ends
});//ready ends