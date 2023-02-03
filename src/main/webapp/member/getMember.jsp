<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.springlab.member.memberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보 조회</title>

	<%
	memberDTO member = (memberDTO) session.getAttribute("member");
	%>
	
</head>
<body>



<center> 
	<h1>회원 상세페이지 </h1>
	<a href = "logout.do"> Log-out </a>
	<hr> 
	<!-- 폼의 value 에  출력  -->
	
	<form action = "updateMember.do" method = "post"> 
		<!-- updateBoard.do 페이지로 넘길때 seq  -->
		<!-- 출력구문에는 나타나지 않고 변수값 넘길때 사용 -->
		<input type="hidden" name ="idx" value = "<%= member.getIdx() %>">
		
		<table border="1" cellspacing ="0" cellpadding="0">
			<tr>
				<td bgcolor="orange" with="80"> 아이디 </td>
				<td> <input type ="text" name="id" value ="<%= member.getId() %>"> </td>
			 </tr>
			 <tr>
				<td bgcolor="orange" > 패스워드 </td>
				<td><input type ="text" name="pass" value ="<%= member.getPass() %>">				
				 </td>
			 </tr>
			 <tr>
				<td bgcolor="orange" > 이름 </td>
				<td> <input type ="text" name="name" value ="<%= member.getName() %>"> </td>
			 </tr>
			  <tr>
				<td bgcolor="orange" > 이메일 </td>
				<td> <input type ="text" name="email" value ="<%= member.getEmail() %>"> </td>
			 </tr>
			 <tr>
				<td bgcolor="orange" > 나이 </td>
				<td><input type ="text" name="age" value ="<%= member.getAge() %>"></td>
			 </tr>
			 <tr>
				<td bgcolor="orange" > 몸무게 </td>
				<td><input type ="text" name="weight" value ="<%= member.getWeight() %>"> </td>
			 </tr>
			 <tr>
				<td bgcolor="orange" > 회원등록날짜 </td>
				<td> <%= member.getRegdate() %> </td>
			 </tr>
			 
			 <tr>
				<td bgcolor="orange" > 회원로그인횟수 </td>
				<td> <%= member.getCnt() %> </td>
			 </tr>
			 
			 <tr>
				<td colspan ="2" align="right"> <input type="submit" value="회원 정보 수정"></td>		
			 </tr>
		</table>
	</form>
	<p> 
	<a href = "deleteMember.do?idx=<%= member.getIdx() %>"> 회원 삭제 </a>&nbsp;&nbsp;&nbsp;
	<a href = "getMemberList.do">회원 목록</a>
	
	
	
</center>

</body>
</html>