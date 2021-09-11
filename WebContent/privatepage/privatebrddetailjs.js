$(document).ready(function(){
	
	$('.replycon').keyup(function(){
		
		$(this).css('height','auto');
		$(this).height(this.scrollHeight);
		
	});
	
	$('.reply').click(function(){
		
		if($('.replyin').css('display') === 'none'){
			$('.replyin').css('display','inline-block');
		}else {
			$('.replyin').hide();
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