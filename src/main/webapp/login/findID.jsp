<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 아이디 비밀번호 찾기 -->
<div class="container">
<p align="right"><a href="MemberfindIDForm.me">[돌아가기]</a></p>
<form method="post" action="MemberfindIDPro.me" onsubmit="return finIDCheck()">
<table class=table>
<tr>
	<th class="active">이름</th>
	<td><input type="text" name="M_name" id="M_name" required></td>
	</tr>
<tr>
<tr>
	<th class="active">이메일주소</th>
	<td><input type="email" name="M_email" id="M_email" required></td>
</tr>
<tr>
	<td colspan="2">
	<input type="submit" value="찾기" class="btn btn-danger">
	</td>
</tr>
</table>
</form>
</div>
<!-- 아이디 비밀번호찾기 끝 -->

<!-- js함수 시작 -->
<script type="text/javascript">
function finIDCheck(){
	let M_name = document.getElementByIf("M_name").value;
	M_name = M_name.trim();
	let M_email = document.getElementByIf("M_email").value;
	M_email = M_email.trim();
}
</script>
<!-- 함수 끝 -->
</body>
</html>