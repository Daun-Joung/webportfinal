$(document).ready(function(){
		
		$("#idch").keyup(function(){
			
			var id = $.trim($(this).val());
				$(this).val(id);
				
				
				if(id.length < 4){
					$("#chtext").html('<span style = "color : red;"> 아이디는 4글자 이상이어야 합니다. </span></td>')
				}else if(id.length > 10){
					$("#chtext").html('<span style = "color : red;"> 아이디는 10글자 이하여야 합니다. </span></td>')
				}else{
					$("#chtext").load("portRegiIdChk.jsp?id=" + id);
					return ;
				}
				
		});
	});


function idch2(){

	var idchch = document.getElementById("idch");
	var pwchch = document.getElementsByName("pwch"); //설명한거 같은데.. 네임은 복수개를 가지고 오는거라고.. 지금 이런 이름으로 되어있는건 하나 아닌가요? 하나만 가져올때는 굳이 쓸필요가 없다는 말씀이신건가요?? 
													 //그리고 생각보다 문장이 조금 적다고 느껴지는 이유는?? 네네 맞아요 
	var pwchch2 = document.getElementsByName("user_pw");
	var chte = document.getElementById("chtext");

	if((idchch.value.length <= 3 ) || (idchch.value.length >=11)){
		
		idchch.focus();
		return false; // form 에서 submit을 할때 해당 조건을 만족하지 않으면 submit이 db로 전달되지 않도록 하는 것. jsp파일에서 submit 버튼에  이벤트 = 'return 함수명()'; 로 선언해 주어야 한다.
		
	}else if((pwchch2[0].value.length <= 4) || (pwchch2[0].value.length > 12)){
		 
		pwchch[0].focus();
		return false;
		
	}else{
		alert("가입성공");
	}
}

	
function pwchfx(){

	var pwchch2 = document.getElementsByName("user_pw");
	var pwchch = document.getElementsByName("pwch");

	if(pwchch[0].value!='' && pwchch2[0].value!='') {
        if(pwchch[0].value==pwchch2[0].value) {
            document.getElementById('pwchdp').innerHTML='비밀번호가 일치합니다.';
            document.getElementById('pwchdp').style.color='blue';
        }
        else {
            document.getElementById('pwchdp').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('pwchdp').style.color='red';
        }
    }

}

/*function idchfx(){
	
	var idch = document.getElementById("idch");
	
		if(idch.value == 'ekdns8341'){
			document.getElementById('chtext').innerHTML='사용가능한 아이디입니다.';
			document.getElementById('chtext').style.color='blue';
			idch.focus();
		}else{
			document.getElementById('chtext').innerHTML='중복된 아이디 입니다.';
			document.getElementById('chtext').style.color='red';
			idch.focus();
		}

}
*/


