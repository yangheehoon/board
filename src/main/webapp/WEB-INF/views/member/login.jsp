<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input {
	width: 100%;
	margin-bottom: 20px;
	height: 40px;
	border: 1px solid gray;
	border-radius: 4px;
	box-sizing: border-box;
}
input[type=submit] {
	border: 1px solid blue;
	background-color: blue;
	color: white;
	font-weight: bolder;
	font-size: medium;
}
</style>
</head>
<body>

<h3 style="text-align: center;">로그인</h3>

<form action="" method="post" style="width: 30%; margin: auto;">
	<input type="text" name="id" placeholder="ID">
	<input type="password" name="pw" placeholder="Password">
	<input type="submit" value="로그인">
</form>

</body>
</html>