<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@page import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>portmain</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;800&family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="portlogin.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="portloginjs.js">
		

		


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
		
	</script>

</head>
	<form action="loginOk.jsp" method="post" onsubmit = "return nullchk()">
	<div class="wrap">
	<div class="headerwrap">
		<header>
		<div class="headertop">
			<div class="snsnav">
				<ul>
					<li><a href="#"><img src="../portimg/snsnav/instagram.png" width="30px" height="30px"></a></li>
					<li><a href="#"><img src="../portimg/snsnav/facebook.png" width="30px" height="30px"></a></li>
					<li><a href="#"><img src="../portimg/snsnav/twitter.png" width="30px" height="30px"></a></li>
					<li><a href="#"><img src="../portimg/snsnav/youtube.png" width="30px" height="30px"></a></li>
					<li><a href="#"><img src="../portimg/snsnav/tik-tok.png" width="30px" height="30px"></a></li>
				</ul>
			</div>
			<div class="regi">
				<ul>
					<li><a href="portlogin.jsp">login</a></li>
					<li><a href="../register/portregi2.jsp">Register</a></li>
				</ul>
			</div>
		</div>
		<div class="headermid">
			<div class="mainlogo"><a href="../main/portmainfinal.jsp">Fit-in</a></div>
		</div>
		<div class="headerbot">
			<div class="mainnav">
				<ul>
					<li><a href="#">HOME</a></li>
					<li><a href="#">MYSTYLE</a></li>
					<li><a href="#">MAGAZINE</a></li>
					<li><a href="../board_01/portBoard_01.jsp">MARKET</a></li>
				</ul>
			</div>
			
		</div>
	</header>
	<section>
		<div class="section_login">
			<div class="sectitle"> 로그인 </div>
			<div>
				<input type="text" name="idin" id = "idin" placeholder="아이디를 입력해주세요.">
			</div>
			<div id = "idfault" >
				
			</div>
			<div>
				<input type="password" name="pwin" id = "pwin" placeholder="비밀번호를 입력해주세요.">				
			</div>
			<div id = "pwfault">
				
			</div>
			<div class="etc">
				<div class="securitychk" >
					<input type="checkbox" name="security" value="보안">보안접속
				</div>
				<div class="search">
					<ul>
						<li><a href="../idpwsrch/portIdSearch.jsp">아이디찾기</a></li>
						<li><a href="#">비밀번호찾기</a></li>
					</ul>
				</div>	
			</div>
			<div class="submitbtn">
				<input type="submit" name="login" value="LOGIN">
			</div>
		</div>
	</section>
	<footer>
		<div class="footerwrap">
			<ul>
				<li class="footerlogo">Fit-in</li>
				<li class="footeradd">www.fit-in.com</li>
				<li class="footerinfo"><a href="#">문의사항</a></li>
			</ul>
		</div>
	</footer>
</div>
</div>
	</form>

<body>

</body>

</html>