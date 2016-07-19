<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "member.MemberService" %>
    <%@page import = "member.MemberServiceImpl" %>
    <%@page import = "member.MemberBean" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>탈퇴하기</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
</head>
<body>
	<div class="box">
	<%
	MemberService service = MemberServiceImpl.getInstance();
	if(service.findBy() == null || service.findBy().getId() == null){
		%>
		<h1>탈퇴하려면 로그인을 해주세요</h1>
		<a href="<%=ctx%>/member/service/login.jsp">로그인 하기</a><br/>
		<%
	} else {
		%>
		<embed src="<%=ctx %>/img/banana.gif">
		<h2>탈퇴하려면 비밀번호를 입력해주세요</h2>
			<form action="<%=ctx %>/member/result/delete_result.jsp" method="post">
				<input type="hidden" name="id" value="<%=service.findBy().getId()%>"/>
				<span class="meta">비밀번호</span><input type="password" name="pw"/><br/><br/>
				<input type="submit" value="탈퇴하기"/>
			</form>
	<%
	}
	%>
		<a href="<%=ctx %>/member/member_controller.jsp">
			<img src="<%=ctx %>/img/member.png" alt="member" style="width: 50px">
		</a>
		<a href="<%=ctx %>/index.jsp">
			<img src="<%=ctx %>/img/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>
</body>
</html>