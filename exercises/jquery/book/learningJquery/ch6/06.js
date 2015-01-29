$(document).ready(
		function() {

			// 6.9
			$('#letter-e a').click(function(event)){
				event.preventDefault();
				var requestData = {term: $(this).text()};
				$.get('e.php',requestData, function(data)){
					$('#dictionary').html(data);
				});
			});
			
			//
			 $('#letter-d a').click(function(event) {
				    event.preventDefault();
				    $.get('d.xml', function(data) {
				      $('#dictionary').empty();
				      $(data).find('entry').each(function() {
				        var $entry = $(this);
				        var html = '<div class="entry">';
				        html += '<h3 class="term">' + $entry.attr('term');
				          html += '</h3>';
				        html += '<div class="part">' + $entry.attr('part');
				          html += '</div>';
				        html += '<div class="definition">';
				        html += $entry.find('definition').text();
				        var $quote = $entry.find('quote');
				        if ($quote.length) {
				          html += '<div class="quote">';
				          $quote.find('line').each(function() {
				            html += '<div class="quote-line">';
				              html += $(this).text() + '</div>';
				          });
				          if ($quote.attr('author')) {
				            html += '<div class="quote-author">';
				              html += $quote.attr('author') + '</div>';
				          }
				          html += '</div>';
				        }
				        html += '</div>';
				        html += '</div>';
				        $('#dictionary').append($(html));
				      });
				    });
				  });
			
			// Listing 6.7
			$('#letter-c a').click(function(event) {
				event.preventDefault();
				$.getScript('c.js');
			})
			// Listing 6.4
			$('#letter-b a').click(
					function(event) {
						event.preventDefault();
						$.getJSON('b.json', function(data) {
							var html = '';
							$.each(data, function(entryIndex, entry) {
								html += '<div class="entry">';
								html += '<h3 class="term">' + entry.term
										+ '</h3>';
								html += '<div class="part"' + entry.part
										+ '</div>';
								html += '<div class="definition">'
										+ entry.definition + '</div>';
								html += '</div>';
								if (entry.quote) {
									html += '<div class="quote">';
									$.each(entry.quote, function(lineIndex,
											line) {
										html += '<div class="quote-line">'
												+ line + '</div>';
									});
								}

								if (entry.author) {
									html += '<div class="quote-author">'
											+ entry.author + '</div>';
								}
							});
							$('#dictionary').html(html);
						});
					});

			$('#letter-a a').click(function(event) {
				event.preventDefault();
				$('#dictionary').load('a.html');
			})
		})