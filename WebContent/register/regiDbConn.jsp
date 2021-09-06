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
<jsp:useBean id = "regi" class= "bean.PortDTO" />
	<jsp:setProperty name = "regi" property ="*" />
	
	<%
	
	PortDAO dao = PortDAO.getInstance();
	
	dao.insertAct(regi);
	
	response.sendRedirect("../main/portmainfinal.jsp");
	
	%>

</body>
</html>