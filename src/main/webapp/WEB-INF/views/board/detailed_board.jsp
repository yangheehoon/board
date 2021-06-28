<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.num}</title>
</head>
<body>

<h3 style="text-align: center;">게시글</h3>

<c:set var="b" value="${board}" ></c:set>
<table border="1" style="margin: auto; width: 60%;">
	<tr>
		<th>제목</th>
		<td colspan="5">${b.title}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${b.nick}</td>
		<th>작성일</th>
		<td>${b.regdate}</td>
		<th>조회수</th>
		<td>${b.hit}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td colspan="5">
			<c:forTokens var="filename" items="${b.files}" delims="," varStatus="st">
				<a download href="/resources/board/${filename}" >${filename}</a>
				<c:if test="${!st.last}">
					/
				</c:if>
			</c:forTokens>		
		</td>
	</tr>
	<tr>
		<td colspan="7" style="height: 300px;">${b.content}</td>
	</tr>

</table>


</body>
</html>