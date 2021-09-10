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
	
	$('#replyregibtn').click(function(){
		
		$.ajax({
			url:"privatebrdreply.do?comm=privatebrdreply",
			type:"post",
			data: { 
				"user_id":$(this).prevAll("#user_id").val(),
				
				"pbrdno":$(this).prevAll("#pbrdno").val(),
				
				"reply_con":$(this).prevAll("#reply_con").val(),
				
				"user_img":$(this).prevAll("#user_img").val()
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
	
	
});