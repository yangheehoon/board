<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
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
		<!-- 게시판 검색 폼 -->
		<form action="">
			<select name="f">
				<option ${(param.f == "title") ? "selected" : ""} value="title">제목</option>
				<option ${(param.f == "nick") ? "selected" : ""} value="nick">작성자</option>
			</select>
			<input type="text" name="q" value="${param.q}">
			<input type="submit" value="검색">	
		</form>
	</div>
	<br>
	<!-- 게시판 테이블 -->
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
				<td><a href="detailed_board?num=${n.num}">${n.title}</a></td>
				<td>${n.nick}</td>
				<td>${n.regdate}</td>
				<td>${n.hit}</td>
			</tr>
		</c:forEach>
	</table>
${count}pages

	<div style="text-align: right;">
		<a href="add_board"><button >게시글 추가</button></a>
	</div>
</div>

<!-- 페이징 변수 -->
<c:set var="page" value="${empty param.p ? 1 : param.p}" />
<c:set var="startpage" value="${page - (page-1)%5}" />
<c:set var="lastpage" value="${Math.ceil(count/10)}" />

<%-- <c:set var="dd" value="${\"2.00\"}" />
<c:set var="ss" value="${45}" />
${dd+ss}
${dd>ss ? 1:2} --%>

<!-- 페이지 목록을 초과하는 페이지를 요청한 경우 -->
<c:if test="${page > lastpage}">
	<p style="text-align: center;">요청하신 페이지 번호는 목록을 초과합니다.<p>
</c:if>

<!-- 페이징 처리 -->
<c:if test="${page <= lastpage}">

	<div style="text-align: center;">
	
		<!-- 이전페이지 -->
		<c:if test="${startpage > 5}">
			<a href="?p=${startpage - 1}&f=${param.f}&q=${param.q}">이전</a>
		</c:if>
	
		<!-- 현재페이지가 마지막 페이지 목록일 경우 -->		
		<c:if test="${startpage+4 >= lastpage}">		
			<c:forEach var="i" begin="0" end="${lastpage==0 ? 0 : lastpage - startpage }">			
				<a href="?p=${startpage+i}&f=${param.f}&q=${param.q}" >${startpage+i}</a>			
			</c:forEach>		
		</c:if>
		
		<!-- 현재페이지가 마지막 페이지 목록이 아닌 경우 -->
		<c:if test="${startpage+4 < lastpage}">
			<c:forEach var="i" begin="0" end="4">
				<a href="?p=${startpage+i}&f=${param.f}&q=${param.q}">${startpage+i}</a>			
			</c:forEach>		
		</c:if>
		
		<!-- 다음페이지 -->
		<c:if test="${startpage+5 <= lastpage}">
			<a href="?p=${startpage + 5}&f=${param.f}&q=${param.q}">다음</a>
		</c:if>

	</div>
				 
</c:if>
    
</body>
</html>