
function nullchk (){
	
	var id = document.getElementById("idin");
	var pw = document.getElementById("pwin");
	
	if(id.value.length == 0){
		
		id.focus();
			document.getElementById("idfault").innerHTML="아이디를 입력하세요"
			document.getElementById("idfault").style.color='red';
			document.getElementById("idfault").style.align='left';
		return false;
		
	}else if(pw.value.length == 0){
		
		pw.focus();
			document.getElementById("pwfault").innerHTML="비밀번호를 입력하세요"
			document.getElementById("pwfault").style.color='red';
		return false;
	
	}
	
}