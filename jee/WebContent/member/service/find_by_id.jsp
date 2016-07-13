<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>내정보 보기</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
	<style>
		body {background-color: yellow;}
		h1   {color: blue;}
		p    {color: red;}
	</style>
</head>
<body>
	<div class ="box">
		<embed width="100%" height="200" src="image.jsp">
		<h1>내정보 보기</h1>
		
		<img src="<%=ctx %>/img/w3schools.jpg" alt="W3Schools.com" width="104" height="142"><br/>
		<a href="<%=ctx %>/member/member_controller.jsp">
			<img src="<%=ctx %>/img/member.png" alt="member" style="width: 50px">
		</a>
		<a href="<%=ctx %>/index.jsp">
			<img src="<%=ctx %>/img/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>	
</body>
</html>