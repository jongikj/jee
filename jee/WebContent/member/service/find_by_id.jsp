<%@page import="com.sun.xml.internal.ws.util.ServiceFinder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="member.MemberService" %>
    <%@page import="member.MemberServiceImpl" %>
    <%@page import="member.MemberBean" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>내정보 보기</title>
	<link rel="stylesheet" href="<%=ctx %>/css/member.css" />
	<style>
		#member_detail{border: 1px solid gray; width:90%; height: 400px; margin:0 auto;border-collapse: collapse;}
		#member_detail tr{border: 1px solid gray;height: 20%}
		#member_detail tr td{border: 1px solid gray;}
		.font_bold{font-weight: bold;}
		.bg_color_yellow{background-color: yellow}
	</style>
</head>
<body>
<!-- id, birth, name, regDate, gender, profileImg -->
	<div class ="box" style="width:500px;margin: 0 auto;text-align: center;">
	<%
	MemberService service = MemberServiceImpl.getInstance();
	if(service.findBy() == null || service.findBy().getId() == null){
		%>
		<h2>로그인을 해주세요.</h2>
		<a href="<%=ctx %>/member/service/login.jsp">로그인 하기</a><br/>
		<%
	} else {
		%>
		<h1>내 정보 보기</h1><br/>
		
		<table id="member_detail">
			<tr>
				<td rowspan="4" width="30%"><img src="<%=ctx %>/img/w3schools.jpg" alt="W3Schools.com" width="104" height="142"><br/></td>
				<td style="width: 20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width: 40%"><%=service.findBy().getId() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이름</td>
				<td><%=service.findBy().getName() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">성별</td>
				<td><%=service.findBy().getGender() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td><%=service.findBy().getEmail() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">SSN</td>
				<td colspan="2"><%=service.findBy().getSsn() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2"><%=service.findBy().getRegDate() %></td>
			</tr>
		</table>
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