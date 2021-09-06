<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@page import="java.io.*"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = (String) session.getAttribute("ID");
%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>portmain</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;800&family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="magazineRegicss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="../login/portloginjs.js"></script>

</head>
	<form action = "magazineregi.do?comm=magazineregi" method="post" enctype="multipart/form-data">
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
				<%
							if (id == null) {
						%>
						<div class="regi">
							<ul>
								<li id="logintxt"><a href="../login/portlogin.jsp">login</a></li>
								<li id="regitxt"><a href="../register/portregi2.jsp">Register</a></li>
							</ul>
						</div>

						<%
							} else {
						%>

						<div class="regi">
							<ul>
								<li id="logintxt"><a href="../login/portlogin.jsp"> <%
 										out.print(id);
 									%>
								</a></li>
								<li id="regitxt"><a href="../login/logOut.jsp">로그아웃</a></li>
							</ul>
						</div>


						<%
							}
						%>
		</div>
		<div class="headermid">
			<div class="mainlogo"><a href="../main/portmainfinal.jsp">Fit-in</a></div>
		</div>
		<div class="headerbot">
			<div class="mainnav">
				<ul>
					<li><a href="#">HOME</a></li>
					<li><a href="#">MYSTYLE</a></li>
					<li><a href="#">PEOPLE</a></li>
					<li><a href="magazinelist.do?comm=magazineList">MAGAZINE</a></li>
					<li><a href="../board_01/portBoard_01.jsp">MARKET</a></li>
				</ul>
			</div>
		</div>
	</header>
	<section>
		
			<div class = "magazineView">
				<input type = "text" name = "magatitle" placeholder="제목을 입력하세요" required="required">
			</div>
			<div class = "magazinecontent">
				<textarea placeholder="내용을 입력하세요" required="required" name = "magacon"></textarea>
			</div>
			<div class = "magazineimg">
				<input type = "file" name = "magaimg">
			</div>
			<div class = "subbtn">
				<input type = "submit" value = "등록">
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