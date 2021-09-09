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
	<link rel="stylesheet" type="text/css" href="portmaincss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="portmainjs.js"></script>
	
</head>

<body>
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
	
		<div id="slideshow" class="sectiontop">
		
		<%
		for(int i=0; i<mainlist.size(); i++){
			%>
			
			<div>
				<div>
					<a href="magazindetail.do?comm=magazineDetail&magano=<%=mainlist.get(i).getMagano()%>">
						<img src="../boardUpload/<%=mainlist.get(i).getMagaimg()%>">
						<div class="imgtxt"><%=mainlist.get(i).getMagatitle()%></div>
					</a>
				</div>
			</div>
			
				
				<%
		}
		%>		
		</div>

		<div class="sectionmid">
			<div class="midtitle">
				<ul>
					<li><a href="#">BODY TYPE</a></li>
					<li><a href="#">WEATHER</a></li>
					<li><a href="#">LOCATION</a></li>
					<li><a href="#">PRICE</a></li>
				</ul>
			</div>
			<div class="midarticle">
				<div class="midarttop">
					<a href="#"><img src="../portimg/user.png" width="30px" height="30px"></a>
					<a href="#">UserID</a>
					<img src="../portimg/cloudy.png" width="30px" height="30px">
				</div>
				<div class="imgslide">
					<div class="arrowleft">
						<img src="../portimg/left-arrow_2.png" width="50px" height="50px">
					</div>
					<div class="imgpart">
						<div>
							<a href=""><img src="../portimg/dailypic/model01.jpg"></a>
						</div>
						<div>
							<a href=""><img src="../portimg/dailypic/mode02.jpg"></a>
						</div>
						<div>
							<a href=""><img src="../portimg/dailypic/model03.jpg"></a>
						</div>
						<div>
							<a href=""><img src="../portimg/dailypic/model04.jpeg"></a>
						</div>
					</div>
					<div class="arrowright">
						<img src="../portimg/right-arrow_2.png" width="50px" height="50px">
					</div>
				</div>
				<div class="midartbot">
					<div>
						<img src="../portimg/like.png" width="30px" height="30px">
						<input type="radio" name="slidenav">
						<img src="../portimg/follower.png" width="30px" height="30px">
						<!-- 옷정보, 가격정보 등 -->
					</div>
					<div>
						<div class="bodytype"> 체격 정보 </div>
						<div class="priceinfo">
							상의 하의 신발 모자 벨트
						</div>
						<div class="showre">
							댓글 리스트
						</div>
						<div class="replyin">
							<input type="text" name="reply">
						</div>
						<!-- 댓글 보여지는 창 - 밑에서 댓글을 입력하면 여기에 반영이 되도록 아마 하나씩 늘어나야 할 듯.-->
					</div>
					<div>
						<!-- input type=text로 댓글 입력 받기 -->
					</div>
				</div>
				<div></div>
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

