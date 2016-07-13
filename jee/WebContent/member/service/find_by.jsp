<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>이름으로 찾기</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
	<style>
		iframe.ifrm{border:none;width: 400px;height: 400px}
	</style>
</head>
<body>
	<div class="box">
		이름으로 찾기 화면<br/>
		<iframe src="image.jsp" class="ifrm" style="border:none"></iframe><br/>
		<a href="<%=ctx %>/member/member_controller.jsp">
			<img src="<%=ctx %>/img/member.png" alt="member" style="width: 50px">
		</a>
		<a href="<%=ctx %>/index.jsp">
			<img src="<%=ctx %>/img/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>
</body>
</html>