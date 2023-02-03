<%@page import="com.springlab.member.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.List" %>
<%@ page import = "com.springlab.member.memberDTO" %>
    
    
    <!-- session으로 저장해서 import없이 사용하기 위해서  -->
<%
 List<memberDTO> memberList =(List) session.getAttribute("memberList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 리스트</title>
</head>
<body>
	<center>
		<h2>회원 정보 LIST</h2>
		<form action = "getmemberList.jsp" method = "post"> 
		<table border = "1" cellspacing = "0" cellpadding = "0" width="700">
		 	<tr> 
		 		<th bgcolor ="orange" width = "100"> 아이디 등록 번호 </th>
		 		<th bgcolor ="orange" width = "200"> 아이디 </th>
		 		<th bgcolor ="orange" width = "150"> 이름 </th>
		 		<th bgcolor ="orange" width = "150"> 이메일 </th>
		 		<th bgcolor ="orange" width = "100">회원가입 일자</th>
		 		<th bgcolor ="orange" width = "100">회원 로그인 횟수 </th>
		 	</tr>
		 
		 <% 
				for (memberDTO dto: memberList) {
			%>
		 	
		 

			<tr>
								
				<td align = "center"><%= dto.getIdx()%></td>
				<td align = "center">
				<a href ="getMember.do?idx=<%= dto.getIdx()%>">
				<%= dto.getId()%></a>
				</td>
				<td align = "center"> <%= dto.getName()%></td>
				<td align = "center"> <%= dto.getEmail() %></td>
				<td align = "center"> <%= dto.getRegdate() %></td>
				<td align = "center"> <%= dto.getCnt() %></td>
			 </tr>
			 
			 <%
				}
			 %>	
		</table>
		
		<p />
		<a href = "getMember.jsp"> 상세보기 </a>
		
		
	</form>
		 
</center>
	
		
			
</body>
</html>