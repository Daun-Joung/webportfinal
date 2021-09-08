

function preview(event){
	
	var reader = new FileReader();
	
	reader.onload = function(event){
		
		var img = document.getElementById("imgup");
		img.setAttribute("src",event.target.result);
	
		
	}
	reader.readAsDataURL(event.target.files[0]);
	
}