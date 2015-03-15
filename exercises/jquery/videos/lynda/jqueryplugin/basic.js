/**
 * 
 */
(function($){
	'use strict';
	
	$.fn.myTogglePlugin = function(){
		$(this).toggle(4000);
	};
	
}(jQuery));
function toggleDiv(){
	$('#main').toggle(400);
}

$(document).ready(function(){
	$('#showButton').click(function(){
		$('.panel:first').myTogglePlugin();
	})
});