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
	<%if(request.getParameter("pw") != ""){  %>
		<h1>변경이 완료되었습니다.</h1>
		<%
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean bean = new MemberBean();
		String pw = request.getParameter("pw");
		service.findBy().setPw(pw);
		service.update(service.findBy());
		
	} else {
		%>
		<h1>변경할 비밀번호를 입력해주세요.</h1>
		<a href="<%=ctx%>/member/service/update.jsp">다시 시도하기</a><br/>
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