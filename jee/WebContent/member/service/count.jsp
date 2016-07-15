<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String ctx = application.getContextPath();%>
    <%@page import="member.MemberService" %>
    <%@page import="member.MemberServiceImpl" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원수</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
</head>
<body>
	<div class="box">
		<%
		MemberService service = MemberServiceImpl.getInstance();
		%>
		<h1>회원은 <%=service.count() %>명 입니다.</h1>
		<a href="<%=ctx %>/member/member_controller.jsp">
			<img src="<%=ctx %>/img/member.png" alt="member" style="width: 50px">
		</a>
		<a href="<%=ctx %>/index.jsp">
			<img src="<%=ctx %>/img/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>
</body>
</html>