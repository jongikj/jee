<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.MemberService" %>
    <%@ page import="member.MemberServiceImpl" %>
    <%@ page import="member.MemberBean" %>
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
<%
	MemberService service = MemberServiceImpl.getInstance();
	MemberBean bean = new MemberBean();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id == null && pw == null){
		%>
		<h2>로그인 실패</h2>
		<a href="<%=ctx %>/member/service/login.jsp">다시 시도하기</a><br />
		<% 	
	}else{
		bean.setId(id);
		bean.setPw(pw);
		String name = service.login(bean);
		if(name == null){
			%>
			<h2>로그인 실패</h2>
			<a href="<%=ctx %>/member/service/login.jsp">다시 시도하기</a><br />
			<%
		}else{
			response.sendRedirect(ctx + "/global/main.jsp");	
		}
	}
%>
</div>
</body>
</html>