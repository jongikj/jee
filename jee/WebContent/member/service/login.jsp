<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>로그인</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
</head>
<body>
	<div class="box">
		<form action="<%=ctx %>/member/result/login_result.jsp" method="post">
			<span class="meta">ID</span><input type="text" name="id"/><br/>
			<span class="meta">비밀번호</span><input type="password" name="pw"/><br/>
			<br /><br /><br />
			<input type="submit" value="로그인"/>		
			<input type="reset" value="취소"/>
		</form>
	</div>
</body>
</html>