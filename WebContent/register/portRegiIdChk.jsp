<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%



Connection conn = null;
Statement stmt = null;

String id = request.getParameter("id");

try{
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webportdbfinal","root","1234"); // 나 이 DB에 연결 할거야.
	if(conn == null)
		throw new Exception("데이터베이스에 연결할 수 없습니다.<br>");
	
	
	stmt = conn.createStatement(); // 연결한 DB에다가 sql 수행문장 쓸꺼야.
	ResultSet rs = stmt.executeQuery("select count(*) as num from userinfo where user_id = '" + id + "';"); // select → executeQuery insert,delete,update → executeUpdate
	//select해서 추출한 데이터를 rs에 담아두겠다.
	
	if(rs.next()){

		if( rs.getInt("num") == 0 ){
			%>
			<span style ="color:blue;">사용가능한 아이디 입니다.</span>
			<%
		}else{
			%>
			<span style ="color:red;">사용할 수 없는 아이디 입니다.</span>
			<%
		}
		
		
	}else{

	}
	
	
	}finally{
	try{
		stmt.close();
	}catch (Exception ignored){
	}
	try{
		conn.close();
	}catch(Exception ignored){
	} 
	}

	
	%>
</body>
</html>