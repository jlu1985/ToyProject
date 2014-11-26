//$.fn.cycle.defaults.timeout=10000;
//$.fn.cycle.defaults.random=true;

$(document).ready(function() {

	var $books = $('#books');
	var $controls = $('<div id="books-controls"></div>');
	$controls.insertAfter($books);
	$('<button>Pause</button>').click(function(event) {
		event.preventDefault();
		$books.cycle('pause');
	}).appendTo($controls);

	$('<button>Resume</button>').click(function(event) {
		event.preventDefault();
		$('ul:paused').cycle('resume');
	}).appendTo($controls);

	$books.hover(function() {
		$books.find('.title').animate({
			backgroundColor : '#eee',
			color : '#000'
		}, 1000);
	}, function() {
		$books.find('.title').animate({
			backgroundColor : '#000',
			color : '#fff'
		}, 1000);
	})
	$('#books').cycle({
		timeout : 100,
		speed : 200,
		pause : true
	});

	$('h1').click(function() {
		$(this).toggleClass('highlighted', 'slow');
	});

	$books.find('.title').resizable();
	
	$('button').button();
})