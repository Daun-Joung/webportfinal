<%@page import="bean.BoardDTO"%>
<%@page import="svc.MarketGetService"%>
<%@page import="svc.MagazineMainService"%>
<%@page import="bean.MagazineDTO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("ID");

List<BoardDTO> searchlist = (List<BoardDTO>)request.getAttribute("searchlist");

DecimalFormat df = new DecimalFormat("###,###");
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
<link rel="stylesheet" type="text/css" href="portBoard_01css.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<script src="portBoard_01js.js">
	
</script>

</head>

<body>
	<form action="mktbdsearch.do?comm=mktbdsearch" method="post">
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
										src="../portimg/snsnav/facebook.png" width="30px"
										height="30px"></a></li>
								<li><a href="#"><img
										src="../portimg/snsnav/twitter.png" width="30px" height="30px"></a></li>
								<li><a href="#"><img
										src="../portimg/snsnav/youtube.png" width="30px" height="30px"></a></li>
								<li><a href="#"><img
										src="../portimg/snsnav/tik-tok.png" width="30px" height="30px"></a></li>
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
								<li id="logintxt"><a href="../login/portlogin.jsp">
										<%
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
								<li><a href="magazineList.do?comm=magazineList">MAGAZINE</a></li>
								<li><a href="../board_01/portBoard_01.jsp">MARKET</a></li>
							</ul>
						</div>
					</div>
				</header>
			</div>
			<section>
				<div class="marketwrap">
					<div class="plusbtn">
						<a href="../board_01/boardregi.jsp"><img
							src="../portimg/plus.png"></a>
					</div>
					<ul>

						<%
							for (int i = 0; i < searchlist.size(); i++) {
						%>

						<li>
							<div class="productwrap">

								<div class="productpic">
									<a href="#"><img
										src="../boardUpload/<%=searchlist.get(i).getMktbdimg()%>"></a>
								</div>
								<div class="producttitle">
									<a href="#"><%=searchlist.get(i).getMktbdtitle()%></a>
								</div>
								<div class="productprice">
									가격:
									<%=df.format(searchlist.get(i).getMktbdprice())%>원
								</div>

							</div>
						</li>

						<%
							}
						%>
					</ul>

					<div class="productsearch">
						<select name="criteria_01" class="criteria_01">
							<option value="1">작성자</option>
							<option value="2">제목</option>
						</select> 
						<select name="criteria_02" class="criteria_02">
							<option value="360">전체</option>
							<option value="1">오늘</option>
							<option value="7">1주일</option>
							<option value="30">1달</option>
						</select>
						<div class="searchboxwrap">
							<input type="text" name="searchbox" placeholder="검색어를 입력하세요">
						</div>
						<div class="searchbtnwrap">
							<input type="submit" name="searchbtn" value="검색">
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

