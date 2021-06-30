<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<style type="text/css">
input {
	width: 100%;
	height: 40px;
	border: 1px solid gray;
	border-radius: 4px;
	box-sizing: border-box;
}
button {
	width : 100%;
	height: 40px;
	border: 1px solid blue;
	border-radius: 4px;
	box-sizing: border-box;
	background-color: blue;
	color: white;
	font-weight: bolder;
	font-size: medium;
	cursor: pointer;
}
button:hover {
	background-color: #4747ff;
}

span {
	display: block;
	margin-bottom: 20px;		
}
</style>
</head>
<body>

<h3 style="text-align: center;">로그인</h3>

<div style="width: 30%; margin: auto;">
	<form action="">
		<input type="text" name="id" id="id" placeholder="ID">
		<span id="msg"></span>
		<input type="password" name="pw" id="pw" placeholder="Password">
		<span id="msg2"></span>
	</form>
	<!-- 화면 전환이 생기지 않게 form 밖에서 버튼 구현 ajax를 통해 요청 --> 
	<button id="login_ck">로그인</button>
</div>

</body>
<script type="text/javascript">
/* 화면 전환 없이 로그인 시도하기 위해 ajax사용 */
$("#login_ck").click(function(){
	
	var login_data = {id : $("#id").val() , pw : $("#pw").val()}
	
	$.ajax({
		url : "login_ck", 
		type : "post",
		data : login_data,
		error : function(){
			alert("ajax 에러");
		},
		success : function(data){
			if(data=="id_doesnt_exist"){
				$("#msg").text("존재하지 않는 아이디입니다").css("color","red");
			}else if(data=="pw_mismatch"){
				$("#msg").text("");
				$("#msg2").text("패스워드가 일치하지 않습니다").css("color","red")
			}else if(data=="success"){
				location.href = "/home";
			}
		}
	})
})

</script>
</html>