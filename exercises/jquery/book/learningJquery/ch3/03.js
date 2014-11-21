$(document).ready(function() {

	// Enable hover effect on the style switcher
	$('#switcher').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	})

	// Allow the style switcher to expand and collapse
	var toggleSwitcher = function(event) {
		if (!$(event.target).is('button')) {
			$('#switcher button').toggleClass('hidden');
		}
	}

	$('#switcher').on('click', toggleSwitcher);

	$('#switcher').click();

	// The setBodyClass() function changes the page style
	// The style switcher state is also updated
	var setBodyClass = function(className) {
		$('body').removeClass().addClass(className);
		$('#switcher button').removeClass('selected');
		$('#switcher-' + className).addClass('selected');
		$('#switcher').off('click', toggleSwitcher);
		if (className == 'default') {
			$('#switcher').on('click', toggleSwitcher);
		}
	}

	// Begin with the switcher-default button "selected"
	$('#switcher-default').addClass('selected');
	// Map key codes to their corresponding buttons to click

	var triggers = {
		D : 'default',
		N : 'narrow',
		L : 'large'
	};

	// Call setBodyClass() when a button is clicked
	$('#switcher').click(function(event) {
		if ($(event.target).is('button')) {
			var bodyClass = event.target.id.split('-')[1];
			setBodyClass(bodyClass);
		}
	});

	// Call setBodyClass() when a key is pressed
	$(document).keyup(function(event) {
		var key = String.fromCharCode(event.which);
		if (key in triggers) {
			setBodyClass(triggers[key]);
		}
	})

	// $('#switcher').click(function(event) {
	// if ($(event.target).is('button')) {
	//
	// var bodyClass = event.target.id.split('-')[1];
	// $('body').removeClass().addClass(bodyClass);
	// $('#switcher button').removeClass('selected');
	// $(event.target).addClass('selected');
	// event.stopPropagation();
	// } else {
	// $('#switcher button').toggleClass('hidden');
	// }
	// })

	// $('#switcher-default').addClass('selected');
	// $('#switcher button').click(function(event) {
	// $('#switcher').off('click', toggleSwitcher);
	// if (this.id == 'switcher-default') {
	// $('#switcher').on('click', toggleSwitcher);
	// }
	//		
	// var bodyClass = this.id.split('-')[1];
	// $('body').removeClass();
	// $('body').removeClass().addClass(bodyClass);
	//		
	// $('#switcher button').removeClass('selected');
	// $(this).addClass('selected');
	// //click event will not bubble out by calling stopProgapation()
	// event.stopPropagation();
	//		
	// //prevent default action will need to call
	// // .preventDefault();
	//		
	// // if need to stop both propagation and default simply return false
	// for
	// the event
	// })

	// $('#switcher-narrow').click(function() {
	// $('body').addClass('narrow')
	// })
	//
	// $('#switcher-large').on('click', function() {
	// $('body').addClass('large');
	//
	// })

	// simulate a user click
	// $('#switcher').trigger('click');

})
