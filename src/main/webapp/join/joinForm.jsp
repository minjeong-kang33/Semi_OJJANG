<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="joiN.css">
<head>
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
<body>
	<form action="MemberJoinPro.me" method="post">
		<!-- 아이디 , 아이디 중복확인 -->
		<div>
			아이디 <input type="text" id="M_id" name="M_id" size="15" required
				onclick="idCheck()"> <input type="button" value="ID중복확인">
			<script type="text/javascript">
				function idCheck() {
					window.open("idCheck.jsp", "nickwin",
							"width=400, height=350");
				}
			</script>
		</div>

		<!-- 비밀번호 -->
		<div>
			비밀번호 <input type="password" id="M_pw" name="M_pw" size="15" required onchange="check_pw()">
		</div>
		<div>
			비밀번호 확인 <input type="password" id="M_pw2" name="M_pw2" size="15" required onchange="check_pw()">&nbsp;<span id="check"></span> 
<%-- 			<%@include file="pwCheck.jsp"%> --%>
		</div>

		<!-- 이름 -->
		<div>
			이름 <input type="text" id="M_name" name="M_name" size="15" required>
		</div>


		<!--닉네임 -->
		<div>
			닉네임 <input type="text" id="M_nick" name="M_nick" size="15" required
				onclick="nickCheck()"> <input type="button" value="닉네임중복확인">
			<script type="text/javascript">
				function nickCheck() {
					window.open("nickCheck.jsp", "nickwin",
							"width=400, height=350");
				}
			</script>

		</div>
		<!-- 이메일 -->
		<div>
			이메일 <input type="email" id="M_email" name="M_email" size="30">
			<input type="button" id="M_id" value="Email 인증"
				onclick="location.href = 'emailSendAction.jsp'">
		</div>
		<div>
		<!--전화번호 -->
			전화번호 <input type="text" id="M_phone" name="M_phone" size="15">
		</div>
		<div>
		<!-- 주소 -->
		우편번호 <input type="text" id="sample6_postcode" placeholder="우편번호">
		<input type="button" onclick="DaumPostcode()" value="우편번호 찾기"><br>
		주소 <input type="text" name="M_address" id="M_address" placeholder="주소"><br>
		상세주소 <input type="text" name="M_address2" id="M_address2" placeholder="상세주소">
		<%@include file="addressMap.jsp"%>
		</div>
		<!-- 성별 -->
		<div>
			성별 <select name="M_gender" id="M_gender">
				<option>선택하세요.</option>
				<option value="남">남자</option>
				<option value="여">여자</option>
			</select>
		</div>

		<input type="submit" value="회원가입" class="btn btn-primary" /> <input
			type="reset" value="취소" class="btn btn-primary" />
	</form>
	
	<!--끝 -->
</body>

</html>
