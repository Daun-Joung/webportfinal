$(document).ready(function(){

		$('#slideshow > div:gt(0)').hide();
		//$('.imgpart > div:gt(0)').hide();
	
		setInterval(function(){
			$('#slideshow > div:first')
			.fadeOut(1000)
			.next()
			.fadeIn(1000)
			.end()
			.appendTo('#slideshow');
		}, 5000);

		$('div.mainnav ul li img').mouseenter(function(){
			$('div.mainnav ul li img').attr('src','../portimg/loupewhite.png')
			$('div.mainnav li div').show();
		});

		$('div.mainnav ul li img').mouseleave(function(){
			$('div.mainnav ul li img').attr('src','../portimg/loupeblack.png')
			$('div.mainnav li div').hide();
		});

		$('.arrowleft img').mouseenter(function(){
			$('.arrowleft img').attr('src','../portimg/left-arrow.png');
		});

		$('.arrowright img').mouseenter(function(){
			$('.arrowright img').attr('src','../portimg/right-arrow.png');
		});

		$('.arrowleft img').mouseleave(function(){
			$('.arrowleft img').attr('src','../portimg/left-arrow_2.png');
		});

		$('.arrowright img').mouseleave(function(){
			$('.arrowright img').attr('src','../portimg/right-arrow_2.png');
		});

		$('.arrowright img').click(function(){
			$('.imgpart > div:first')
			.next()
			.appendTo('.imgpart');
		});

		$('.arrowleft img').click(function(){
			$('.imgpart > div:first')
			.prev()
			.appendTo('.imgpart');
		});

	});

		