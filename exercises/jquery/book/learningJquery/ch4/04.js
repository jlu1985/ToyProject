$(document).ready(function() {

	// =================================
	// step five - toggling visibility
	// =================================
	$(document).ready(function() {
		var $firstPara = $('p').eq(1);
		$firstPara.hide();

		$('a.more').click(function(event) {
			event.preventDefault();

			// using condition
			// if ($firstPara.is(':hidden')){
			// $firstPara.fadeIn('slow');
			// $(this).text('read less');
			// } else {
			// $firstPara.fadeOut('slow');
			// $(this).text('read more');
			// }

			// using toggle
			$firstPara.slideToggle('slow');
			var $link = $(this);
			if ($link.text() == 'read more') {
				$link.text('read less')
			} else {
				$link.text('read more')
			}
		})
	})

	// =================================
	// step four - show and hide element
	// =================================
	// .eq() same as :eq() selector
	// $('p').eq(1).hide();
	// $('a.more').click(function(event) {
	// // once again preventDefault() prevent the default actions of a link
	// event.preventDefault();
	//
	// // we can passing duration for show() / hide() accepts
	// // 'fast','slow',numeric values
	// // $('p').eq(1).show('slow');
	//
	// // or use fadeIn() and fadeOut()
	// // $('p').eq(1).fadeIn('slow');
	//
	// // or use slideUp() and slideDown();
	// $('p').eq(1).slideDown('slow');
	// $(this).hide();
	// })
	// =================================

	// =================================
	// step three - refactoring, apply to all buttons
	// =================================
	// var $speech = $('div.speech');
	// var defaultSize = $speech.css('fontSize')
	//	
	// $('#switcher button').click(function() {
	// var num = parseFloat($speech.css('fontSize'));
	// switch (this.id) {
	// case 'switcher-large':
	// num *= 1.25;
	// break;
	// case 'switcher-small':
	// num /= 1.25;
	// break;
	// default:
	// num = parseFloat(defaultSize);
	// }
	// $speech.css('fontSize', num + 'px');
	// })
	// =================================

	// =================================
	// step two - apply to smaller button
	// =================================
	// var $speech = $('div.speech');
	// $('#switcher button').click(function() {
	// var num = parseFloat($speech.css('font-size'));
	// if (this.id == 'switcher-small') {
	// num /= 1.25;
	// } else if (this.id == 'switcher-large') {
	// num *= 1.25;
	// }
	// $speech.css('fontSize', num + 'px');
	// })
	// =================================

	// =================================
	// step one - basics, getting font size and pare with parseFloat()
	// =================================
	// $('#switcher-large').click(function(){
	// var num = parseFloat($speech.css('fontSize'));
	// num *= 1.4;
	// $speech.css('fontSize',num+'px');
	// })
	// =================================
})