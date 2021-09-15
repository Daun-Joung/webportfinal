<%@page import="svc.MagazineMainService"%>
<%@page import="bean.MagazineDTO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@page import="java.io.*"%>
<% request.setCharacterEncoding("utf-8"); %>

<%

	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("ID");

 
	
%>

<!DOCTYPE html>

<html>

<head>

	<meta charset="utf-8">
	<title> portmain </title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;800&family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="boardregicss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="boardregijs.js"></script>
	
</head>

<body>
	<form action="mktbdregi.do?comm=mktbdregi" method="post" enctype="multipart/form-data">
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
			
			if(id == null){
					
			%>
			<div class="regi">
				<ul>
					<li id="logintxt"><a href="../login/portlogin.jsp">login</a></li>
					<li id="regitxt"><a href="../register/portregi2.jsp">Register</a></li>
				</ul>
			</div>
			
			<%	}else{ %>
			
			<div class="regi">
				<ul>
					<li id="logintxt"><a href="../login/portlogin.jsp"><% out.print(id);%></a></li>
					<li id="regitxt"><a href="../login/logOut.jsp">로그아웃</a></li>
				</ul>
			</div>
			
			<%
			}
			%>
			
		</div>
		<div class="headermid">
			<div class="mainlogo"><a href="../main/portmainfinal.jsp">FIT-IN</a></div>
		</div>
		<div class="headerbot">
			<div class="mainnav">
				<ul>
					<li><a href="../main/portmainfinal.jsp">HOME</a></li>
					<li><a href="../privatepage/privatebrd.jsp">MYSTYLE</a></li>
					<li><a href="../brdtotal/total.jsp">PEOPLE</a></li>
					<li><a href="magazineList.do?comm=magazineList">MAGAZINE</a></li>
					<li><a href="../board_01/portBoard_01.jsp">MARKET</a></li>
				</ul>
			</div>
		</div>
	</header>
	</div>
	<section>
		<div class="privateinforegiwrap">
			<div class="secondwrap">
			<div class="userpic">
				<div class="imgup">
					<img src="http://placehold.it/350x350" id="imgup">
				</div>
		
			</div>
			<div class="bodysize">
			
				<div class="productinfo">
					<div class="titlewrap">
						<input type="text" name="mktbdtitle" id ="producttitle" placeholder="제목을 입력하세요">
					</div>
					<div class="pricewrap">
						<input type="text" name="mktbdtitle" id ="producttitle" placeholder="가격을 입력하세요">
					</div>
					<div class="conwrap">
						<textarea name="productcon" id="mktbdcon" placeholder="내용을 입력하세요"></textarea>
					</div>
				</div>
					<div class = "doublebtn">
				<div class="imgupbtn">
					<label for="input-file" class="inputfile">
						사진 업로드
					</label>
					<input type="file" name="user_img" id="input-file" accept="image/*" onchange="preview(event);" style="display:none;">
				</div>
			
				<div class="bodysizeregibtn">
					<input type="submit" name="profilein" id ="profilein" value="상품 등록">
					<input type="hidden" name="user_id" value="<%=id%>">
				</div>
				</div>
			</div>
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
	</form>
</body>
</html>

