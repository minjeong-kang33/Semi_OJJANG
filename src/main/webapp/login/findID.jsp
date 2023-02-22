<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고의류거래: 옺장</title>
</head>
<body>
<!-- 아이디 비밀번호 찾기 -->
<fieldset class="joinUpField">
	<legend style="border: none; font-weight: 550; color: black;">아이디, 비밀번호 찾기</legend>
	<form method="post" action="MemberfindIDPro.me" onsubmit="return finIDCheck()">
		<ul>
		<li style="list-style-type: none;">
			<label for="usernick" style="color: black; font-weight: 530; margin-right: 15px;">이름</label> 
			<input type="text" id="M_name" name="M_name" maxlength="15" autofocus required> 
		</li>
		<li style="list-style-type: none; margin-top: 5px;">
			<label for="usernick" style="color: black; font-weight: 530;">이메일</label> 
			<input type="email" id="M_email" name="M_email" maxlength="30" autofocus required> 
		</li>
		<li style="list-style-type: none; margin-left: 110px; margin-top: 10px;">
			<input type="submit" value="찾기" class="btn btn-danger" style="border: 0px solid #e7e7e7; font-size: 13px;
				font-weight: 500; letter-spacing: 1px; padding: 5px; background-color: #E8E4E1; border-radius: 3px;">
		</li>
		</ul>
	</form>
</fieldset>
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