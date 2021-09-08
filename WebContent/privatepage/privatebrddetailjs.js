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
	
});