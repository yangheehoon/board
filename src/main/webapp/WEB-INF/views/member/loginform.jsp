<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/> 
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
	<form action="/login" method="post">
		<input type="text" name="username" id="id" placeholder="ID">
		<span id="msg"></span>
		<input type="password" name="password" id="pw" placeholder="Password">
		<span id="msg2"></span>
		<!-- <input type="submit" value="로그인"> --> 
	</form>
	<!-- 화면 전환이 생기지 않게 form 밖에서 버튼 구현 ajax를 통해 요청 --> 
	
	<button id="login_ck">로그인</button>
</div>

</body>
<script type="text/javascript">
/* 화면 전환 없이 로그인 시도하기 위해 ajax사용 */
$("#login_ck").click(function(){
	
	var login_data = {id : $("#id").val() , pw : $("#pw").val()}
	var token = $("#_csrf").attr("th:content");
	var header = $("#_csrf_header").attr("th:content");
	
	$.ajax({
		url : "login_ck", 
		type : "post",
		data : login_data,
		beforeSend : function(xhr){   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
			xhr.setRequestHeader(header, token);
        },
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
				var form = document.createElement('form'); 
				var objs1;
				var objs2;
				var objs3;
				var objs4;
				objs1 = document.createElement('input'); 
				objs1.setAttribute('type', 'text'); 
				objs1.setAttribute('name', 'username'); 
				objs1.setAttribute('value', $('#id').val()); 
				objs2 = document.createElement('input'); 
				objs2.setAttribute('type', 'text'); 
				objs2.setAttribute('name', 'password'); 
				objs2.setAttribute('value', $('#pw').val()); 
				objs3 = document.createElement('input'); 
				objs3.setAttribute('type', 'text'); 
				objs3.setAttribute('name', '_csrf'); 
				objs3.setAttribute('value', token); 
				objs4 = document.createElement('input'); 
				objs4.setAttribute('type', 'text'); 
				objs4.setAttribute('name', '_csrf_header'); 
				objs4.setAttribute('value', header); 				
				form.appendChild(objs1);
				form.appendChild(objs2);
				form.appendChild(objs3);
				form.appendChild(objs4);
				form.setAttribute('method', 'post'); 
				form.setAttribute('action', "/login"); 
				document.body.appendChild(form);
				form.submit();

			}
		}
	})
})

</script>
</html>