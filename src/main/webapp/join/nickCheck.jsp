<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nickCheck.jsp</title>
</head>
<body>
	<div style="text-align: center">
		<h3>닉네임 중복확인</h3>
		<form method="post" action="MembernikCheckPro.me"
			onsubmit="return nickCheck(this)">
			닉네임 : <input type="text" name="M_nick"  maxlength="15" autofocus>
			<input type="submit" value="중복확인">
		</form>
	</div>

	<script>
		function nickCheck(f) {
			var M_nick = f.M_nick.value;
			M_nick = M_nick.trim();
			if (M_nick.length < 3) {
				alert("닉네임은 3자 이상 입력해주십시오.");
				return false;
			}//if end
			return true;
		}//blankCheck() end
	</script>
</body>
</html>