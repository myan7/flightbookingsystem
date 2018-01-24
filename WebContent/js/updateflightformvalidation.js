//updateflightformvalidation.js
$(document).ready(function() 
{
	$.validator.addMethod("validarrivaldate", function(value) {
		var x = Date.parse(document.getElementById("dtime").value);
		var y = Date.parse(document.getElementById("atime").value);
		return x<y;
	});
	$.validator.addMethod('airportcode', function (value) { 
	    return  /^[A-Za-z][A-Za-z][A-Za-z]$/.test(value); 
	}, 'Please enter a valid airport code.');
	$("#updateflightform").validate(
	{
		rules:
		{
			seatsNO:
			{
				required: true,
				range: [0, 540]
			},
			dcity:
			{
				required: true
			},
			dport:
			{
				required: true,
				airportcode: true
			},
			dtime:
			{
				required: true
			},
			acity:
			{
				required: true
			},
			aport:
			{
				required: true,
				airportcode: true
			},
			atime:
			{
				required: true,
				validarrivaldate: true
			}
		},
		messages:
		{
			seatsNO:
			{
				required: "Seats Number is mandatory",
				range: "Seats number must be between 0 and 540"
			},
			dcity:
			{
				required: "Departure port must be in origin city"
			},
			dport:
			{
				required: "Please enter the airport code of the origin",
				airportcode: "Please look into IATA airport code"
			},
			dtime:
			{
				required: "Please enter the departure time"
			},
			acity:
			{
				required: "Arrival port must be in destination city"
			},
			aport:
			{
				required: "Please enter the airport code of the destination",
				airportcode: "Please look into IATA airport code"
			},
			atime:
			{
				required: "Please enter the arrival time",
				validarrivaldate: "Arrival time should be later than departure time"
			}
		},
		submitHandler: function(form) 
		{
			form.submit();
		}
	});//validate ends
});//ready ends