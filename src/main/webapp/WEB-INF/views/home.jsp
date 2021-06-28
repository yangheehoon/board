<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<a href="/member/join">회원가입</a>
<a href="/member/login">로그인</a>
<a href="/board/boardlist">게시판 목록</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
