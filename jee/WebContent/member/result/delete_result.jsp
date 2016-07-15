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
	<title>탈퇴완료</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
</head>
<body>
	<div class="box">
	<%
	MemberService service = MemberServiceImpl.getInstance();
	MemberBean bean = new MemberBean();
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals(service.findBy().getId()) && pw.equals(service.findBy().getPw())){
		service.delete(service.findBy().getId());
		
		%>
		<h1>탈퇴가 완료되었습니다. 잘가</h1>
		<%
	} else {
		%>
		<h1>정보를 정확히 입력해주세요</h1>
		<a href="<%=ctx%>/member/service/delete.jsp">다시 시도하기</a><br/>
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