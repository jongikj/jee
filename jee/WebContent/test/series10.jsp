<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<%
		int i = 0, j = 0;
		for (i = 1; i <= 10; i++) {
			j += i; 
	%>
	<%= i %> 
	<% if(i==10){break;} %>+
	<% } %>
	= <%= j %>
</body>
</html>