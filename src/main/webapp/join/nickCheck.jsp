<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nickCheck.jsp</title>
</head>
<body>
<fieldset class="joinUpField">
	<legend style="border: none; font-weight: 530; color: black;">닉네임 중복확인</legend>
	<form method="post" action="MembernikCheckPro.me" onsubmit="return nickCheck(this)">
		<ul>
			<li style="list-style-type: none;">
				<label for="usernick" style="color: black; font-weight: 530;">닉네임</label> 
				<input type="text" id="M_nick" name="M_nick" maxlength="15" autofocus> 
				<input type="submit" value="중복확인" style="border: 0px solid #e7e7e7; font-size: 13px;
						font-weight: 500; letter-spacing: 1px; padding: 5px; background-color: #E8E4E1; border-radius: 3px;">
			</li>
		</ul>
	</form>
</fieldset>
	
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