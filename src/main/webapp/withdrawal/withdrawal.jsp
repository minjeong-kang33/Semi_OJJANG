<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%
String M_id = (String) session.getAttribute("M_id");
%>

<body>
	<h3>회원탈퇴</h3>
	 <div class="container">
	 <p align="right"><a href="MemberLoginForm.me">[돌아가기]</a></p>	
	<form action="MemberwithdrawalPro.me" onsubmit="return withdrawCheck()" method="post">	
		아이디 : <input type="text" name="M_id" value="<%=M_id%>" readonly><br>
		비밀번호 : <input type="password" name="M_pw" id="M_pw" required><br>
		<div>
			탈퇴사유 <select name="re" id="re">
				<option value="0">선택하세요.</option>
				<option value="1">원하는 상품이 없어요.</option>
				<option value="2">비매너 사용자를 만났어요.</option>
				<option value="3">물품이 안팔려요.</option>
				<option value="4"> 기타 </option>
			</select>
			<script type="text/javascript">
	function withdrawCheck(){
	let M_pw = document.getElementById("M_pw").value;
	M_pw = M_pw.trim();
	let message="진행된 내용은 복구되지 않습니다. \n계속 진행 할까요?";
	if(confirm(message)){
		return true;
		else{
			return false
		}
	}
	}
	</script>
		</div>
		<input type="submit" value="회원탈퇴">
	</form>
	</div>
	
	
	
	
</body>
</html>