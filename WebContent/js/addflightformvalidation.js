$(document).ready(function(){
	$.validator.addMethod('flightno', function (value) { 
	    return  /^[A-Z][A-Z]\d{4}$/.test(value); 
	}, 'Please enter a valid Passport Number.');
	
	$.validator.addMethod('airportcode', function (value) { 
	    return  /^[A-Za-z][A-Za-z][A-Za-z]$/.test(value); 
	}, 'Please enter a valid airport code.');
	$.validator.addMethod("validarrivaldate", function(value) {
		var x = Date.parse(document.getElementById("DepartureTime").value);
		var y = Date.parse(document.getElementById("ArrivalTime").value);
		return x<y;
	});
	
	$("#addflightform").validate({
		
		/*
		 * ^: Start of line;
			[A-PR-WY]: One of A-P, R-W or Y - in other words, A-Z excluding Q, X and Z;
			[1-9]: Any digit except 0, no repetitions;
			\d: Any digit, no repetitions;
			\s?: Zero or one white-space characters;
			\d{4}: Exactly four digits;
			[1-9]: Any digit except 0, no repetitions;
			$: End of line;
		 */
		rules:
		{
			FlightNO:
			{
				required: true,
				flightno: true
			},
			SeatsNO:
			{
				required: true,
				range: [0, 540]
			},
			DepartureTime:
			{
				required: true
			},
			DeparturePort:
			{
				required: true,
				airportcode: true
			},
			ArrivalTime:
			{
				required: true,
				validarrivaldate: true
			},
			ArrivalPort:
			{
				required: true,
				airportcode: true
			}
		},
		messages:
		{
			FlightNO:
			{
				required: "Flight Number is mandatory",
				flightno: "Invalid Flight Number"
			},
			SeatsNO:
			{
				required: "Seats Number is mandatory",
				range: "Seats number must be between 0 and 540"
			},
			DepartureTime:
			{
				required: "Please enter the departure time"
			},
			DeparturePort:
			{
				required: "Please enter the airport code of the origin",
				airportcode: "Please look into IATA airport code"
			},
			ArrivalTime:
			{
				required: "Please enter the arrival time",
				validarrivaldate: "Arrival time should be later than departure time"
			},
			ArrivalPort:
			{
				required: "Please enter the airport code of the destination",
				airportcode: "Please look into IATA airport code"
			}
		},
		submitHandler: function(form) 
		{
			form.submit();
		}
	});// validate ends
});	//ready ends