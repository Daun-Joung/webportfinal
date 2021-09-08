<%@page import="bean.PrivateBrdDTO"%>
<%@page import="svc.PrivateBrdSelService"%>
<%@page import="bean.PrivateInfoDTO"%>
<%@page import="svc.MystyleMainService"%>
<%@page import="svc.MagazineMainService"%>
<%@page import="bean.MagazineDTO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@page import="java.io.*"%>
<% request.setCharacterEncoding("utf-8"); %>

<%

	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("ID");

 	MagazineMainService srv = MagazineMainService.instance();
	List<MagazineDTO> mainlist = srv.mainSelect();
	
	MystyleMainService mystylesrv = MystyleMainService.instance();
	List<PrivateInfoDTO> profilelist = mystylesrv.getPrivateInfo(id);
	
	PrivateBrdSelService pbss = PrivateBrdSelService.instance();
	List<PrivateBrdDTO> pbrdlist = pbss.getPrivateBrd(id);
	
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
	<link rel="stylesheet" type="text/css" href="privatebrddetailcss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="privatebrddetailjs.js"></script>
	
</head>

<body>
	<form action="PrivateBrdRegi.do?comm=privateBrdRegi" method="post" enctype="multipart/form-data">
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
			<div class="mainlogo"><a href="../main/portmainfinal.jsp">Fit-in</a></div>
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
		<div class="detailwrap">
			<div class="detailheader">
				<div class="detailheaderwrap">
					<div class="user_pic">
						<img src ="../portimg/user.png">
					</div>
					<div class="user_id"> <%=id %></div>
					<div class="headermenu">
						<img src="../portimg/menu.png">
					</div>
				</div>
			</div>
			<div class="detailsection">
				<div class="pbrd_pic">
					<img src="http://placehold.it/600x600">
				</div>
			</div>
			<div class="detailmiddle">
				<div class="privateinfodetail">
					<ul>
						<li>키: 176cm</li>
						<li>몸무게: 84kg</li>
						<li>상의사이즈: xxl</li>
						<li>하의사이즈: 32</li>
						<li>신발사이즈: 270</li>
					</ul>
				</div>
			</div>
			<div class="detailfooter">
				<div class="likeandreply">
					<div class="like">
						<span><img src="../portimg/like.png"></span>
						<label>좋아요</label>
					</div>
					<div class="reply">
						<span><img src="../portimg/message.png"></span>
						<label>댓글달기</label>
					</div>
				</div>
				<div class="replywrap"></div>
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

