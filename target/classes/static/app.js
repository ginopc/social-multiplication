function updateMultiplication() {
	
	// Cleans the form
	$('#result-attempt').val('');
	$('#user-alias').val('');
	
	$.ajax({
		url: "http://localhost:3000/multiplications/random"
	}).then(function(data) {
		
		// Gets a random challenge from API and loads the data in the HTML
		$('.multiplication-a').empty().append(data.factorA);
		$('.multiplication-b').empty().append(data.factorB);
	});
}

$(document).ready(function() {
	
	// update form
	updateMultiplication();
	
	$("#attempt-form").submit(function( event ) {
		// Don't submit the form normally
		event.preventDefault();

		// Get some values from elements on the page
		var a = $('.multiplication-a').text();
		var b = $('.multiplication-b').text();
		var attempt = $('.result-attempt').text();
		var userAlias = $('.user-alias').text();
		
		// Compose the data in the format that the API is expecting
		var data = { 
				user: { alias: userAlias}
				, multiplication: {factorA: a, factorB: b}
				, resultAttempt: attempt};
		
		// Send the data using post
		$.ajax({
			url: '/results',
			type: 'POST',
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(result){
				if(result.correct) {
					$('.result-message').empty().append("The result is correct! Congratulations!");
				} else {
					$('.result-message').empty().append("Oops that's not correct! But keep trying!");
				}
			}
		});
		
		updateMultiplication();
	});
});		