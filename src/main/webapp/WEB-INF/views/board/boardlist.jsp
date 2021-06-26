<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style type="text/css">
table {
	margin: auto;
}
th {
	text-align: center;
}
</style>
</head>
<body>

<div style="width: 80%; margin: auto;">
	<h3 style="text-align: center;">게시판 목록</h3>

	<div style="text-align: right;">
		<form action="" method="post">
			<select>
				<option ${(param.f == "title") ? "selected" : ""} value="title">제목</option>
				<option ${(param.f == "nick") ? "selected" : ""} value="nick">작성자</option>
			</select>
			<input type="text" name="q" value="${param.q}">
			<input type="submit" value="검색">	
		</form>
	</div>
	<br>
	<table border="1" style="width: 100%;">
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.num}</td>
				<td>${n.title}</td>
				<td>${n.nick}</td>
				<td>${n.regdate}</td>
				<td>${n.hit}</td>
			</tr>
		</c:forEach>
	</table>
${count}pages

	<div style="text-align: right;">
		<a href="AddBoard"><button >게시글 추가</button></a>
	</div>
</div>

</body>
</html>