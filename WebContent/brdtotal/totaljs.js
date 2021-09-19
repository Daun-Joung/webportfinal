$(document).ready(function(){
	
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
	
	$("#replyregibtn").click(function(){
		
		var user_id = $(this).parents("#replyin").find("#user_id").val();
		var pbrdno = $(this).parents("#replyin").find("#pbrdno").val();
		var reply_con = $(this).parents("#replyin").find("#reply_con").val();
		var user_img = $(this).parents("#replyin").find("#user_img").val();
	
		$.ajax({
			url:"privatebrdreply.do?comm=privatebrdreply",
			type:"post",
			data: { 
				"user_id": user_id,
				
				"pbrdno": pbrdno,
				
				"reply_con": reply_con,
				
				"user_img": user_img
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

		var likecount = $(this).find('#likecountchk').val();
		
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
	
		
	$('.headermenu img').click(function(){
			event.stopPropagation();
			$(this).next('.upanddel').css('display','inline-block')
		
	});
	
	$(document).click(function(){
		
			$('.upanddel').hide();
	});
	
	
	
});