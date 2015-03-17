/**
 * 
 */

// Utility Functions begins
function isNotNumber(value) {
	return (isNaN(value) || value == null || value === '');
}

// Utility Functions Ends

// Section one function: calculate total
function calTotal() {
	var result = $('#cal-result');
	var inputs = $('#calculateTotal > input.cal-input')
	var total = 0;

	inputs.each(function(i, el) {
		total += parseFloat(isNotNumber(el.value) ? 0 : el.value)
	});

	result.text(total);
};

// Section two function: Counting characters
function getCount(field, callback) {
	'use strick';
	var $field = field;
	var count = $field.val().length;
	var limit = $field.attr('maxLength');
	var $statusField = $field.parent().children('.commentbox-status');
	callback($statusField, limit, count);
}

function updateCharLimit(field, limit, count) {
	'use strick';
	var $field = field;
	var html = count + " of " + limit;
	$field.text(html);
}

// On Load binding
$(document).ready(function() {
	'use strict';

	$('#calculateTotal > input.cal-input').blur(calTotal);
	$('#calculateTotal > input.cal-input').keyup(calTotal);
	calTotal();

	$('#count_remaining_char .commentbox').keyup(function() {
		getCount($(this), updateCharLimit);
	}).keyup();
	
});
