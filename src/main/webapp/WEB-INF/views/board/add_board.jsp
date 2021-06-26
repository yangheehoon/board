<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="width: 60%; margin: auto;">
	<div style="text-align: center;">
		<h3>게시글 추가</h3>
	</div>
	<form action="" method="post" onsubmit="return ck()" enctype="multipart/form-data">
		<input type="text" placeholder="제목" name="title" style="width: 100%;">
		<br><br>
		<textarea rows="10" style="width: 100%;" name="content" placeholder="내용"></textarea>
		<input type="hidden" name="nick" value=${"test"}>
		<input type="file" name="reqfiles" multiple="multiple">
		<div style="text-align: right;">
			<input type="submit" value="게시글 등록">
		</div>
	</form>
</div>

</body>
<script type="text/javascript">
function ck() {
	if(document.getElementsByName("title")[0].value == ""){
		alert("제목을 입력해주세요");
		return false;
	}else if(document.getElementsByName("content")[0].value == ""){
		alert("내용을 입력해주세요");
		return false;	
	}
}

</script>
</html>