<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ojjang_pop</title>
<script>
function setCookie(name, value, expiredays) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + expiredays);
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}

function fun1() {
	if ( document.form1.popup.checked )
	setCookie( "popup2", "done" , 1);
	self.close();
}
</script>
</head>
<body>
<form name="form1">
<input type="image" src="assets/images/pop2.png" onclick="fun1()"><br>
<input type="checkbox" name="popup" value="" style="accent-color: #704A00">
<font size="2">오늘 하루 그만 보기</font> <input type="button" onclick="fun1()" value="닫기">
</form>
</body>
</html>