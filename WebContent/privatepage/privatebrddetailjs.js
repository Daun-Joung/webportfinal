$(document).ready(function(){
	
	$('.replycon').keyup(function(){
		
		$(this).css('height','auto');
		$(this).height(this.scrollHeight);
		
	});
	
	$('.reply').click(function(){
		
		if($('.replyin').css('display') === 'none'){
			$('.replyin').css('display','inline-block');
		}else{
			$('.replyin').hide();
		}
		
		
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
	
	
});