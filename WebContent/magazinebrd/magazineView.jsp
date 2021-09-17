<%@page import="bean.PageInfo"%>
<%@page import="bean.MagazineDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.io.*"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = (String) session.getAttribute("ID");

	List<MagazineDTO> magazinelist = (List<MagazineDTO>) request.getAttribute("MagazineList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("PageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>portmain</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;800&family=Paytone+One&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../magazinebrd/magazineViewcss.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="../magazinebrd/magazineViewjs.js"></script>

</head>
<form>
	<div class="wrap">
		<div class="headerwrap">
			<header>
				<div class="headertop">
					<div class="snsnav">
						<ul>
							<li><a href="#"><img
									src="../portimg/snsnav/instagram.png" width="30px"
									height="30px"></a></li>
							<li><a href="#"><img
									src="../portimg/snsnav/facebook.png" width="30px" height="30px"></a></li>
							<li><a href="#"><img src="../portimg/snsnav/twitter.png"
									width="30px" height="30px"></a></li>
							<li><a href="#"><img src="../portimg/snsnav/youtube.png"
									width="30px" height="30px"></a></li>
							<li><a href="#"><img src="../portimg/snsnav/tik-tok.png"
									width="30px" height="30px"></a></li>
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
					<div class="mainlogo">
						<a href="../main/portmainfinal.jsp">FIT-IN</a>
					</div>
				</div>
				<div class="headerbot">
					<div class="mainnav">
						<ul>
							<li><a href="../main/portmainfinal.jsp">HOME</a></li>
							<li><a href="../privatepage/privatebrd.jsp">MYSTYLE</a></li>
							<li><a href="../brdtotal/total.jsp">PEOPLE</a></li>
							<li><a href="magazinelist.do?comm=magazineList">MAGAZINE</a></li>
							<li><a href="../board_01/portBoard_01.jsp">MARKET</a></li>
						</ul>
					</div>
				</div>
			</header>
			<section>
				<table>
					<%
						if (magazinelist != null && listCount > 0) {

							for (int i = 0; i < magazinelist.size(); i++) {
					%>

					<tr>
						<td>
							<div class="listimg" id="listimgdiv">
								<a
									href="magazinedetail.do?comm=magazineDetail&magano=<%=magazinelist.get(i).getMagano()%>&page=<%=nowPage%>">
									<!-- 수정 --> 
									<img id="listimg" src="../boardUpload/<%out.print(magazinelist.get(i).getMagaimg());%>">
								</a>
							</div>
						</td>
						<td>
							<div class="listtitle">
								<a
									href="magazinedetail.do?comm=magazineDetail&magano=<%=magazinelist.get(i).getMagano()%>&page=<%=nowPage%>">
									<!-- 수정 -->
									<p>
										<%
											out.print(magazinelist.get(i).getMagatitle());
										%>
									</p>
								</a> 
								<div class="readcount">
								조회수 :
								<%
									out.print(magazinelist.get(i).getMaga_readcount());
								%>
								</div>
							</div>
						</td>
					</tr>

				<%
				}
						%>	
				</table>
				
				<div class="pageinfo">	
							<%
				if (nowPage <= 1) {
				%>
				이전
				<%
					} else {
				%>
				<a href="magazinelist.do?comm=magazineList&page=<%=nowPage - 1%>">이전</a>
				<%
					}
				%>

				<%
					for (int a = startPage; a <= endPage; a++) {
							if (a == nowPage) {
				%>
				[<%=a%>]
				<%
					} else {
				%>
				<a href="magazinelist.do?comm=magazineList&page=<%=a%>">[<%=a%>]
				</a>
				<%
					}
				%>
				<%
					}
				%>

				<%
					if (nowPage >= maxPage) {
				%>
				다음
				<%
					} else {
				%>
				<a href="magazinelist.do?comm=magazineList&page=<%=nowPage + 1%>">다음</a>
				<%
					}
				%>

				<%
					} else {
				%>
				<p>등록된 글이 없습니다.</p>
				<%
					}
				%>
				</div>	
				
				
				<%
					if (id != null) {
						if (id.equals("ekdns8341")) {
				%>

				<div class="magaregibtn">
					<a href="../magazinebrd/magazineRegi.jsp"><input type="button"
						value="매거진 등록"></a>
				</div>

				<%
					}
					}
				%>

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