/**
 * 
 */

$(document).ready(function(){
	'use strict';
	
	var recalTotal = function(){
		var result = $('#result');
		var inputs = $('#recalculate > input.recal')
		
		var total = 0;
		
		inputs.each(function(i,el)	{
			total+=parseFloat(el.value);
		});
		
		result.text(total);
	};
	
	$('#recalculate > input.recal').blur(recalTotal);
	$('#recalculate > input.recal').keyup(recalTotal);
	recalTotal();
	
});