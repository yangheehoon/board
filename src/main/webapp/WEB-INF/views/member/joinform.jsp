<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
input {
	width: 100%;
	margin-bottom: 15px;
	height: 35px;
	border: 1px solid gray;
	border-radius: 4px;
	box-sizing: border-box;
}
input[type=submit] {
	border: 1px solid blue;
	background-color: blue;
	color: white;
	font-weight: bolder;
	font-size: 15px;
}
select {
	width: 100%;
	margin-bottom: 15px;
}
</style>
</head>
<body>

<h3 style="text-align: center;">회원가입 양식</h3>

<form action="" method="post" onsubmit="return ck()" style="width: 50%; margin: auto;">
	<input type="text" name="id" id="id" placeholder="아이디">
	<input type="password" name="pw" placeholder="패스워드">
	<input type="password" name="pw2" placeholder="패스워드 확인">
	<input type="text" name="nick" placeholder="닉네임">
	<input type="text" name="name" placeholder="이름">
	<select name="gender">
		<option>성별을 선택해주세요</option>
		<option value="남자">남자</option>
		<option value="여자">여자</option>
	</select>
	<input type="email" name="email" placeholder="이메일">
	<input type="text" name="address" placeholder="주소">
	<input type="text" name="phone" placeholder="전화번호">
	<input type="text" name="birth" placeholder="주민등록번호 ">
	<input type="submit" value="회원가입">
</form>

</body>
<script type="text/javascript">
function ck(){
	if(document.getElementsByName("id")[0].value==""){
		alert("아이디를 입력해주세요.");
		return false;
	}else if(document.getElementsByName("pw")[0].value==""){
		alert("패스워드를 입력해주세요.");
		return false;
	}else if(document.getElementsByName("pw2")[0].value==""){
		alert("패스워드 확인을 입력해주세요.");
		return false;
	}else if(document.getElementsByName("pw")[0].value!=document.getElementsByName("pw2")[0].value){
		alert("패스워드가 일치하지않습니다 패스워드를 다시 확인해주세요.");
		return false;
	}else if(document.getElementsByName("nick")[0].value==""){
		alert("닉네임을 입력해주세요.");
		return false;
	}else if(document.getElementsByName("name")[0].value==""){
		alert("이름을 입력해주세요.");
		return false;
	}else if(document.getElementsByName("gender")[0].value=="성별을 선택해주세요"){
		alert("성별을 선택해주세요.");
		return false;
	}else if(document.getElementsByName("email")[0].value==""){
		alert("이메일을 입력해주세요.");
		return false;
	}else if(document.getElementsByName("address")[0].value==""){
		alert("주소를 입력해주세요.");
		return false;
	}else if(document.getElementsByName("phone")[0].value==""){
		alert("전화번호를 입력해주세요.");
		return false;
	}else if(document.getElementsByName("birth")[0].value==""){
		alert("주민등록번호를 입력해주세요.");
		return false;
	}
}
</script>

</html>