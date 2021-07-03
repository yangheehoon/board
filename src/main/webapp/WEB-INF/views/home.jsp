<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	환영합니다. ${sessionScope.member.id}<c:if test="${sessionScope.member.id!=null}">님</c:if>
</h1>

<a href="/member/joinform">회원가입</a>
<c:if test="${sessionScope.member.id==null}">
	<a href="/member/loginform">로그인</a>
</c:if>
<c:if test="${sessionScope.member.id!=null}">
	<a href="#" onclick="document.getElementById('logout').submit();">로그아웃</a>
	<form id="logout" action="/member/logout" method="POST" style="display: none;">
   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</c:if>
<a href="/board/boardlist">게시판 목록</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
