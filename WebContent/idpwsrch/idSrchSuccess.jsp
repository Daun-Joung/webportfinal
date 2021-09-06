<%@page import="bean.PortDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PortDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@page import="java.io.*"%>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>portmain</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;800&family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="idSrchSuccesscss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


</head>
	<form>
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
					<li><a href="../login/portlogin.jsp">login</a></li>
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
					<li><a href="#">PEOPLE</a></li>
					<li><a href="#">MAGAZINE</a></li>
					<li><a href="#">MARKET</a></li>
				</ul>
			</div>

		</div>
	</header>
	<section>
	
	<div class="section_Search">
			<div class="sectitle"> 아이디찾기 </div>
			<div class ="searchnamein">
	
	<%
	
		String idsrch_name = request.getParameter("srchnamein");
		String idsrch_email = request.getParameter("srchemailin");
	
		PortDAO dao = PortDAO.getInstance();
		
		ArrayList<PortDTO> dto = dao.idsrchGet(idsrch_name, idsrch_email);
		
		if(dto.size() != 0){
			for(int i=0; i<dto.size(); i++){
				
				%>
					<p>고객님의 아이디는 <%out.print(dto.get(i).getUser_id()); %>입니다.</p>		
				<%	
			}		
		}else{
			response.sendRedirect("idSrchfail.jsp");
		}
	%>			
				</div>
			<div class="submitbtn">
				<a href="../login/portlogin.jsp"><input type="button" name="login" value="로그인 하기"></a>
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