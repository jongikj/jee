<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="member.MemberService" %>
    <%@page import="member.MemberServiceImpl" %>
    <%String ctx = application.getContextPath();%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>내정보 수정</title>
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
		<h1>회원 상세정보</h1><br/>
		<%MemberService service = MemberServiceImpl.getInstance(); %>
		<table id="member_detail">
			<tr>
				<td rowspan="5" width="30%"><img src="<%=ctx %>/img/member/<%=service.findBy().getProfileImg() %>" alt="W3Schools.com" width="104" height="142"><br/></td>
				<td style="width: 20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width: 40%"><%=service.findBy().getId() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이름</td>
				<td><%=service.findBy().getName() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">비밀번호</td>
				<td><input type="text" name="pw" value="<%=service.findBy().getPw() %>"/></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">성별</td>
				<td><%=service.findBy().getGender() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td><input type="text" name="email" value="<%=service.findBy().getEmail() %>"/></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">생년월일</td>
				<td colspan="2"><%=service.findBy().getBirth() %></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2"><%=service.findBy().getRegDate() %></td>
			</tr>
		</table>
		
		<a href="<%=ctx %>/member/member_controller.jsp">
			<img src="<%=ctx %>/img/member.png" alt="member" style="width: 50px">
		</a>
		<a href="<%=ctx %>/index.jsp">
			<img src="<%=ctx %>/img/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>	
</body>
</html>