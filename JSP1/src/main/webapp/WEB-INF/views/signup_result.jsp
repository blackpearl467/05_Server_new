<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 가입 결과</title>
</head>
<body>

	<h3>회원 가입 결과 페이지 입니다</h3>
	
	<h4>입력되어 전달된 값들</h4>
	
	<ul>
		<li>ID: <%= request.getParameter("inputId") %> </li>
		<li>PW: <%= request.getParameter("inputPw") %></li>
		<li>확인: <%= request.getParameter("inputPwCheck") %></li>
		<li>이름: <%= request.getParameter("inputId") %></li>
		<li>나이: <%= request.getParameter("inputAge") %></li>
	</ul>

	<!-- JSTL 사용 시 : 비밀번호가 일치하는 경우 -->
	<c:if test="${param.inputPw==param.inputPwCheck}">
	<h3 style="color: green;">로그인성공!</h3>
	</c:if>
	
	<!-- JSTL 사용 시 : 비밀번호가 일치하지 않는 경우 -->
	<c:if test="${param.inputPw!=param.inputPwCheck}">
	<h3 style="color: red;">비밀번호 불일치</h3>
	</c:if>
	
</body>
</html>