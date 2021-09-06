<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="portregiscript2.js"></script>
</head>
<body>

	<% request.setCharacterEncoding("utf-8"); %> <!-- 데이터를 넘겨주는 form의 method가 post면 반드시 이 메소드를 넣어줘야 한다. 그래야 한글을 인식함 -->



<%

	String id = request.getParameter("idin");
	String pw = request.getParameter("pwch");
	String name = request.getParameter("namein");
	String email = request.getParameter("emailin") + request.getParameter("emaildefault");
	String birth = request.getParameter("year") + request.getParameter("month") + request.getParameter("day");
	String cell = request.getParameter("hpin");
	String gender = request.getParameter("gender");
	String addre = request.getParameter("addnum") + request.getParameter("addmain") + request.getParameter("adddetail") + request.getParameter("adddetail_2");
	
	
	if(id == null || pw == null || name == null || email == null || birth == null || cell == null || gender == null || addre == null)
		throw new Exception("누락된 데이터가 있습니다.");
	
	Connection conn = null;
	Statement stmt = null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/webportdbfinal","root","1234");
		
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.");
		
		stmt = conn.createStatement();
		String command = String.format("insert into userinfo values('%s','%s','%s','%s','%s','%s','%s','%s');",id,pw,name,email,birth,cell,gender,addre);
		int rowNum = stmt.executeUpdate(command);
		if(rowNum < 1 )
			throw new Exception("데이터를 DB에 입력할 수 없습니다.");
	} finally {
		try{
			stmt.close();
		} catch(Exception ignored){
		}
		try{
			conn.close();
		}catch(Exception ignored){
		}
	}
	response.sendRedirect("portmainfinal.jsp");
%>




</body>
</html>