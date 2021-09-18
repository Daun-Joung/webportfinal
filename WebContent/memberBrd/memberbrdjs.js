$(document).ready(function(){
	
	$('.privatebrdcon').keyup(function(){
		
		$(this).css('height','auto');
		$(this).height(this.scrollHeight);
		
	});
	
	
});



function imgpreview(event){
	
	var reader = new FileReader();
	
	reader.onload = function(event){
		
		var img = document.getElementById("previewbox");
		img.setAttribute("src",event.target.result);
		img.style.display = "block";
	}
	reader.readAsDataURL(event.target.files[0]);
	
}