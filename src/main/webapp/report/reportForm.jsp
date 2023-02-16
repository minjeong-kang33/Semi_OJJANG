<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
<link rel="stylesheet" type="text/css" href="assets/css/reportForm.css"/>


<script type="text/javascript">

function fun2() {
	window.close();
} 
</script>

</head>
<body>

<%
String M_id=(String)session.getAttribute("M_id");
String R_id = request.getParameter("R_id");
String R_writeNum = request.getParameter("R_writeNum");
String R_category = request.getParameter("R_category");
String R_title = request.getParameter("R_title");


if(M_id==null){
	response.sendRedirect("login/loginForm.jsp"); //맞나?
}
%>



<%-- 신고하기 폼 --%>
<div class="reportForm">
	<form action="ReportPro.rpt" method="post" name="reportWriteBox">
	<input type="hidden" name="M_id" value="<%=M_id %>">
 	<input type="hidden" name="R_id" value="<%=R_id %>">
	<input type="hidden" name="R_writeNum" value="<%=R_writeNum %>">
	<input type="hidden" name="R_category" value="<%=R_category %>">
	<input type="hidden" name="R_title" value="<%=R_title %>">
	<span class="reportInfo"><img src="assets/images/danger.png" class="dangerIcon">  클릭하여 신고 이유를 선택해 주세요.</span> 
	<select id="selectBox" name="R_type">
		<option value=""> -- 선택하세요 --</option>
		<option value="회원비난/비하"> 회원비난/비하 </option>
		<option value="욕설/비속어"> 욕설/비속어 </option>
		<option value="무단광고/홍보"> 무단광고/홍보 </option>
		<option value="도배"> 도배 </option>
		<option value="아이디/DB거래"> 아이디/DB거래 </option>
		<option value="음란성/선정성"> 음란성/선정성 </option>
		<option value="기타"> 기타 </option>
	</select><br>

	<textarea rows = "5" cols = "19" class="textarea" name="R_reason" placeholder=" 내용을 입력해 주세요."></textarea><br>
	<li> 정상적인 게시물을 신고하시는 경우 본인이 제재를 당할 수 있습니다.</li>
	<li> 신고하게 된 이유를 사제히 써주시면 운영자의 관련 결정에 도움이 됩니다.</li>

<input type="submit" value="신고하기"> <input type="button" value="취소하기" onclick="fun2()">
</form>      
</div>


 <!-- jQuery 이 밑으로만 제이쿼리 문법 작성-->
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>

<script type="text/javascript">
	jQuery('#selectBox').change(function() {
	var state = jQuery('#selectBox option:selected').val();
	if ( state == "기타" ) {
		jQuery('.textarea').show();
	} else {
		jQuery('.textarea').hide();
	}
	});	
	
</script>
		
</body>
</html>