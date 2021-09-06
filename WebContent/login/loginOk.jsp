<%@page import="java.io.PrintWriter"%>
<%@page import="dao.PortDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("utf-8"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

	String id = request.getParameter("idin"); // 입력한 아이디받아오기
	String pw = request.getParameter("pwin"); // 입력한 비밀번호 받아오기
	
	PortDAO dao = PortDAO.getInstance();
	PrintWriter script = response.getWriter();
	
	int loginresult = dao.loginChk(id, pw); // dao에 매개변수로 입력받은 id, pw 전달.
	
	if(loginresult == 1){
		session.setAttribute("ID",id);
		response.sendRedirect("../main/portmainfinal.jsp");
	}else if(loginresult == 2){
		script.println("<script>");
		script.println("alert('비밀번호가 틀렸습니다.')");
		script.println("location.href='portlogin.jsp'"); // 코드의 수행순서 jsp태그 > html(스크립트) 태그 → jsp태그인 response.sendRedirect();를 쓰면 alert가 실행되기 전에 이동부터 된다. 따라서 스크립트 태그를 이용해 페이지를 이동시켜야 한다.
		script.println("</script>");
	}else if(loginresult == 3){
		script.println("<script>");
		script.println("alert('잘못된 아이디입니다.')");
		script.println("location.href='portlogin.jsp'");
		script.println("</script>");
	}

%>
	
</body>
</html>