$(document).ready(function() {
	$('#switcher h3').click(function(){
		$('#switcher button').toggleClass('hidden');
	})
	
	$('#switcher h3').hover(function(){
		$(this).addClass('hover');
	}, function(){
		$(this).removeClass('hover');
	})
	
	$('#switcher-default').addClass('selected');
	$('#switcher button').click(function() {
		
		var bodyClass = this.id.split('-')[1];
		$('body').removeClass();
		$('body').removeClass().addClass(bodyClass);
		
		$('#switcher button').removeClass('selected');
		$(this).addClass('selected');
	})
	
	
	
//	$('#switcher-narrow').click(function() {
//		$('body').addClass('narrow')
//	})
//
//	$('#switcher-large').on('click', function() {
//		$('body').addClass('large');
//
//	})

	
})
