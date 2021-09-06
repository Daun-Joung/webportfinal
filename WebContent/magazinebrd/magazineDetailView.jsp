<%@page import="bean.PageInfo"%>
<%@page import="bean.MagazineDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %> 
<%@page import="java.io.*"%>

<%
	request.setCharacterEncoding("utf-8");

	String id = (String)session.getAttribute("ID");
	
	List<MagazineDTO> magaDetail = (List<MagazineDTO>)request.getAttribute("magadetail");
	String nowPage = (String) request.getAttribute("page");
	
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
	<link rel="stylesheet" type="text/css" href="../magazinebrd/magazineDetailViewcss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="../magazinebrd/magazineViewjs.js"></script>

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
			<% for(int i=0; i<magaDetail.size(); i++){ %>
			<div class="contentwrap">
				<div>
					<ul>
						<li class="magazinedate">Published Date</li>
						<li class="date"><%= magaDetail.get(i).getMagadate()%></li>
					</ul>
				</div>
				<div class="magazinetitle">
					<%= magaDetail.get(i).getMagatitle() %>
				</div>
				<div class="magazinecontent">
					<%= magaDetail.get(i).getMagacon() %>
				</div>
			
			<%
			}
			%>
			<%
			if(id != null){
				if(id.equals("ekdns8341")){			
				%>
			
			<div>
				<ul>
				<% for(int j=0; j<magaDetail.size(); j++){%>
					<li><a href="magazineupdatesel.do?comm=magazineUpdateSel&magano=<%=magaDetail.get(j).getMagano()%>&page=<%=nowPage%>"><input type = "button" value = "수정" class = "magaregibtn"></a></li>
					<li><a href="magazinedelete.do?comm=magazineDelete&magano=<%=magaDetail.get(j).getMagano()%>"><input type = "button" value = "삭제" class= "magaregibtnsec"></a></li>
				<%} %>
				</ul>	
			</div>	
			
			<%
				}
			}
			%>
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