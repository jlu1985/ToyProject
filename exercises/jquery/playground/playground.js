/**
 * 
 */
function isNotNumber(value) {
	return (isNaN(value) || value == null || value === '');
}

function calTotal() {
	var result = $('#cal-result');
	var inputs = $('#calculateTotal > input.cal-input')

	var total = 0;

	inputs.each(function(i, el) {
		total += parseFloat(isNotNumber(el.value) ? 0 : el.value)
	});

	result.text(total);
};

$(document).ready(function() {
	'use strict';

	$('#calculateTotal > input.cal-input').blur(calTotal);
	$('#calculateTotal > input.cal-input').keyup(calTotal);
	calTotal();
});
