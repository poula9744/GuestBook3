<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.GuestVo"%>
<%
	List<GuestVo> guestList = (List<GuestVo>) request.getAttribute("guestList");	
%>
<%
	int id = Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook3/gbc" method="get">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<input type="hidden" name="no" value="<%=id %>">
				<input type="hidden" name="action" value="delete">
				<td><button type="submit">삭제</button></td>
			</tr>
		</table>
	</form>
	
	<br><br>
	<a href="/guestbook3/gbc?action=wform">메인으로 돌아가기</a>
</body>
</html>