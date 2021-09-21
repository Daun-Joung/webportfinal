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
		
		$('.replycon').keyup(function(){
		
		$(this).css('height','auto');
		$(this).height(this.scrollHeight);
		
	});
	
	$('.reply').click(function(){
		
		if($(this).parents('.likeandreply').next('.replywrap').find('.replyin').css('display') === 'none'){
			$(this).parents('.likeandreply').next('.replywrap').find('.replyin').css('display','inline-block');
		}else{
			$(this).parents('.likeandreply').next('.replywrap').find('.replyin').hide();
		}
		
		
	});
	
	$('.headermenu img').click(function(){
			event.stopPropagation();
			$(this).next('.upanddel').css('display','inline-block')
		
	});
	
	$(document).click(function(){
		
			$('.upanddel').hide();
	});
	
	
	$('#replyregibtn').click(function(){
		
		$.ajax({
			url:"privatebrdreply.do?comm=privatebrdreply",
			type:"post",
			data: { 
				"user_id":$("#user_id").val(),
				
				"pbrdno":$("#pbrdno").val(),
				
				"reply_con":$("#reply_con").val(),
				
				"user_img":$("#user_img").val()
				},
			
			success :function onData(data){
				location.reload();
			},
			error: function onError(error){
				console.error(error);
			}
			
		})
		
	});
	
	$('#like').click(function(){

		var likecount = $('#likecountchk').val();
		
		if(likecount == 0){
			
			$.ajax({
			url:"prvbrdlikein.do?comm=prvbrdlikein",
			type:"post",
			data: { 
				"user_id":$("#user_id").val(),
				
				"pbrdno":$("#pbrdno").val(),

				},
			
			success :function onData(data){
				location.reload();
			},
			error: function onError(error){
				console.error(error);
			}
			
		})
			
		}else{
			
			$.ajax({
			url:"prvbrdlikedel.do?comm=prvbrdlikedel",
			type:"post",
			data: { 
				"user_id":$("#user_id").val(),
				
				"pbrdno":$("#pbrdno").val(),

				},
			
			success :function onData(data){
				location.reload();
			},
			error: function onError(error){
				console.error(error);
			}	
		})
		}
	
	});

	});

		