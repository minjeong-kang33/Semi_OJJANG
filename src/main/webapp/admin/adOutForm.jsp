<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강퇴하기</title>
<link rel="stylesheet" type="text/css" href="assets/css/reportForm.css"/>


<script type="text/javascript">

function fun2() {
	window.close();
} 
</script>

</head>
<body>

<%
String M_id=(String)request.getParameter("M_id");
%>



<%-- 강퇴하기 폼 --%>
<div class="reportForm">
	<form action="AdUserDelete.ad" method="post">
	<input type="hidden" name="M_id" value="<%=M_id %>">
	<span class="reportInfo"><img src="assets/images/danger.png" class="dangerIcon">  클릭하여 강퇴 사유를 선택해 주세요.</span>
	<select id="selectBox" name="R_type">
		<option value=""> -- 선택하세요 --</option>
		<option value="회원비난/비하"> 회원비난/비하 </option>
		<option value="욕설/비속어"> 욕설/비속어 </option>
		<option value="무단광고/홍보"> 무단광고/홍보 </option>
		<option value="도배"> 도배 </option>
		<option value="아이디/DB거래"> 아이디/DB거래 </option>
		<option value="음란성/선정성"> 음란성/선정성 </option>
	</select><br>

<input type="submit" value="강퇴하기"> <input type="button" value="취소하기" onclick="fun2()">
</form>      
</div>
</body>
</html>