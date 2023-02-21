<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고의류거래: 옺장</title>
</head>
<body>
	<div style="text-align: center">
		<h3>아이디 중복확인</h3>
		<form method="post" action="MemberidCheckPro.me"
			onsubmit="return idCheck(this)">
		
			아이디 : <input type="text" name="M_id"  maxlength="15" autofocus>
			<input type="submit" value="중복확인">
		</form>
	</div>

	<script>
		function idCheck(f) {
			var M_id = f.M_id.value;
			M_id = M_id.trim();
			if (M_id.length < 5) {
				alert("아이디는 5자 이상 입력해주십시오.");
				return false;
			}//if end
			return true;
		}//blankCheck() end
	</script>
</body>
</html>