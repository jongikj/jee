<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>1부터 10까지의 합</title>
</head>
<body>
<%
	int sum = 0;
	for(int i=1; i<=10; i++){
		sum += i;
	}	// 스크립트릿 안은 그냥 자바...
%>
1부터 10까지의 합은 <%= sum %> 입니다.
</body>
</html>