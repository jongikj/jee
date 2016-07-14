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
	char c = 9;
	int i = 0, j = 0;
	for(i=1; i<=9; i++){
		for(j=2; j<=5; j++){
			%><%=j + " * " + i + " = " + i*j%>  &nbsp;&nbsp;
			<%
		}
		%><br /><%
	}
	%>
	<br />
<%
	for(i=1; i<=9; i++){
		for(j=6; j<=9; j++){
			%><%=j + " * " + i + " = " + i*j%>	&nbsp;&nbsp;
			<%
		}
		%><br /><%
	}
%>
</body>
</html>