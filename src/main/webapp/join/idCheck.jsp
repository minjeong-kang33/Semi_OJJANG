<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고의류거래: 옺장</title>
</head>
<body>
<fieldset class="joinUpField">
	<legend style="border: none; font-weight: 530; color: black;">ID 중복확인</legend>
	<form method="post" action="MemberidCheckPro.me" onsubmit="return idCheck(this)">
		<ul>
			<li style="list-style-type: none;">
				<label for="userid" style="color: black; font-weight: 530;">아이디</label> 
				<input type="text" id="M_id" name="M_id" maxlength="15" autofocus> 
				<input type="submit" value="ID중복확인" style="border: 0px solid #e7e7e7; font-size: 13px;
						font-weight: 500; letter-spacing: 1px; padding: 5px; background-color: #E8E4E1; border-radius: 3px;">
			</li>
		</ul>
	</form>
</fieldset>

	<script>
		function idCheck(f) {
			var M_id = f.M_id.value;
			M_id = M_id.trim();
			if (M_id.length < 5) {
				alert("아이디를 5자 이상 입력해주십시오.");
				return false;
			}//if end
			return true;
		}//blankCheck() end
	</script>
</body>
</html>