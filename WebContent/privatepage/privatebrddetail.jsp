<%@page import="bean.BoardGetDTO"%>
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

	MystyleMainService mystylesrv = MystyleMainService.instance();
	List<PrivateInfoDTO> profilelist = mystylesrv.getPrivateInfo(id);
	
	List<BoardGetDTO> brddetail = (List<BoardGetDTO>)request.getAttribute("brddetail");
	int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));
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
	
		<%
		for(int i=0;i<brddetail.size();i++){
		%>
		
		<div class="detailwrap">
			<div class="detailheader">
				<div class="detailheaderwrap">
					<div class="user_pic">
						<img src ="../privateProfileUpload/<%=brddetail.get(i).getUser_img()%>">
					</div>
					<div class="user_id"> <%=brddetail.get(i).getId()%></div>
					<div class="headermenu">
						<img src="../portimg/menu.png">
					</div>
				</div>
			</div>
			<div class="detailsection">
				<div class="pbrd_pic">
					<img src="../privateBrdUpload/<%=brddetail.get(i).getPbrd_pic()%>">
				</div>
			</div>
			<div class="detailmiddle">
				<div class="privateinfodetail">
					<ul>
						<li>키: <%=brddetail.get(i).getUser_height() %>cm</li>
						<li>몸무게: <%=brddetail.get(i).getUser_weight()%>kg</li>
						<li>상의사이즈: <%=brddetail.get(i).getUser_top() %></li>
						<li>하의사이즈: <%=brddetail.get(i).getUser_bottom() %></li>
						<li>신발사이즈: <%=brddetail.get(i).getUser_shoe() %></li>
					</ul>
				</div>
			</div>
						
		<%	
		}
		%>
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
				<div class="replywrap">
					<div class="printreply"></div>
					<div class="replyin">
						<div class="replypic">
						<%
						for(int i=0;i<profilelist.size();i++){
						%>
							<img src ="../privateProfileUpload/<%=profilelist.get(i).getUser_img()%>">
						<%	
						}
						%>
						
							
						</div>
						<div class="replybox">
							<input type="hidden" id= "user_id" value="<%=id%>" />
							
							<input type="hidden"  id= "pbrdno" value="<%=pbrdno%>" />
							<%
							for(int i=0;i<profilelist.size();i++){
								%>
								
								<input type="hidden" id="user_img" value="../privateProfileUpload/<%=profilelist.get(i).getUser_img()%>">
								
								<%
							}
							%>
							<textarea placeholder="댓글을 입력하세요" id ="reply_con" ></textarea>
							<input type="button" value="댓글 등록" id="replyregibtn">
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

