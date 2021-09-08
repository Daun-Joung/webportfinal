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
	<link rel="stylesheet" type="text/css" href="privatebrdcss.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="privatebrdjs.js"></script>
	
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
		<div class="brdwrap">
			<div class="brdprivateinfo">
				<div class="privateinfo">
					<div class="profilepic">
						<div>
							<%
						if(id != null){
							for(int i=0;i<profilelist.size();i++){
								%>
								<img src ="../privateProfileUpload/<%=profilelist.get(i).getUser_img()%>">
								<%
							}
						}else{
							%>
							<img src ="../portimg/user.png">
							<%
						}
					%>	
						</div>
					</div>
					<div class="profileinfo">
						<div class="btnarea">
							<div class="idin"> <%=id %> </div>
							<div class="btnin">
							<%
							if(profilelist.size() == 1){
								%>
								<a href="../privatepage/privateinforegi.jsp"><input type ="button" name ="profileupbtn" value="프로필 편집"></a>
							
							<%
							}else{
								%>
								<a href="../privatepage/privateinforegi.jsp"><input type ="button" name ="profileupbtn" value="프로필 등록"></a>
							<%
							}
							%>
								
							</div>
						</div>
						<div class = "profilenum">
							<div class="follow">
								<p>팔로워</p>
								<p>숫자</p>
							</div>
							<div class="follow">
								<p>팔로잉</p>
								<p>숫자</p>
							</div>
							<div class="follow">
								<p>게시글</p>
								<p>숫자</p>
							</div>
						</div>			
					</div>
				</div>
				<div class = "brdregi">
					<div class="userpic">
					<%
						if(id != null){
							for(int i=0;i<profilelist.size();i++){
								%>
								<img src ="../privateProfileUpload/<%=profilelist.get(i).getUser_img()%>">
								<%
							}
						}else{
							%>
							<img src ="../portimg/user.png">
							<%
						}
					%>			
					</div>
					<div class="brdconwrap">
						<div class="brdconin">
							<input type="hidden" name="user_id" value="<%=id%>">
							<textarea class="privatebrdcon" name="pbrd_con" placeholder="<%=id%>님 오늘 의상은 어떠신가요?"></textarea>
							<div id="imgpreview">
								<img src="http://placehold.it/700x700" id="previewbox" style="display:none;">
							</div>
						</div>
						<div class="regibtn">
							<div class="brdregipic" id="brdregipic">
								<span><img src ="../portimg/camera.png"></span>
								<label for="pbrd_img" class="text">사진/동영상</label>
								<input type="file" name="pbrd_pic" id="pbrd_img" accept="image/*" onchange ="imgpreview(event);" style="display:none;">
							</div>
							<div class="brdregibtn" id="brdregibtn">
								<label for="pbrd_regi" id="brdsubbtn">등록</label>
								<input type="submit" name="pbrdregi" id="pbrd_regi" style="display:none;">
							</div>
						</div>
					</div>
				</div>
				<div class="brdgallery">
					<ul>
					<%
						for(int i=0;i<pbrdlist.size();i++){
							%>
							<li>
								<a href="../privatepage/privatebrddetail.jsp"><img src="../privateBrdUpload/<%=pbrdlist.get(i).getPbrd_pic()%>"></a>
							</li>	
						<%							
						}
					%>
					</ul>
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

