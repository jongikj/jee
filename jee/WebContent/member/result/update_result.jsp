<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "member.MemberService" %>
    <%@page import = "member.MemberServiceImpl" %>
    <%@page import = "member.MemberBean" %>
    <%String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>변경 완료</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
</head>
<body>
	<div class = "box">
		<%
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean bean = service.findById(request.getParameter("id"));
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		bean.setPw(pw);
		bean.setEmail(email);
		
		service.update(bean);
		response.sendRedirect(ctx + "/member/service/detail.jsp");
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