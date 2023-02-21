<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>중고의류거래: 옺장</title>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
<link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
<link rel="stylesheet" href="assets/css/owl-carousel.css">
<link rel="stylesheet" href="assets/css/lightbox.css">
<link rel="stylesheet" href="assets/css/joinForm.css">
</head>

<body>
	<!-- ***** 헤더 ***** -->
	<jsp:include page="../top.jsp" />
	<!-- ***** 헤더 끝 ***** -->

	<!-- ***** 배너 시작 ***** -->
	<div class="page-heading about-page-heading" id="top">
		<div class="container">
			<div class="inner-content2">
				<img src="assets/images/banner_img.png" width="100%">
			</div>
		</div>
	</div>
	<!--     ***** 배너 끝 ***** -->

	<!-- ***** 게시판 제목 시작 ***** -->
	<div class="joincontainer">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-heading">
					<h2>회원 가입</h2>
					<span>Member Register</span>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** 게시판 제목 끝 ***** -->

	<!-- ***** 회원가입 폼 시작 ***** -->
	<form action="MemberJoinPro.me" method="post" id="join_area">
	
		<!-- 아이디 , 아이디 중복확인, 비밀번호, 비밀번호 확인 -->
		<fieldset class="joinUpField">
			<legend>로그인 정보</legend>
				<ul>
					<li><label for="userid">아이디</label> <input type="text" id="M_id" name="M_id" size="15" required onclick="idCheck()"> 
						<input type="button" value="ID중복확인" id="joinbutton">
						
						<script type="text/javascript">
						function idCheck() {
							window.open("MemberidCheckForm.me", "nickwin",
									"width=450, height=150");
						}
						</script>
					</li>
					<li><label for="pwd1"> 비밀번호</label> 
						<input type="password" id="M_pw" name="M_pw" size="15" required onchange="check_pw()">
					</li>
					<li><label for="pwd2">비밀번호 확인</label> 
						<input type="password" id="M_pw2" name="M_pw2" size="15" required onchange="check_pw()">&nbsp;<span id="check"></span></li>
				</ul>
		</fieldset>
		<!-- 아이디 , 아이디 중복확인, 비밀번호, 비밀번호 확인 끝 -->
		
					<br><%@include file="pwCheck.jsp"%>
		
		<!-- 기타 개인정보 입력 -->
		<fieldset>
			<legend>개인 정보</legend>
				<ul>
					<li><label for="fullname">이름</label> <input type="text" id="M_name" name="M_name" size="15" required></li>
					<li><label for="gender">성별</label> 
					<input type="radio" name="M_gender" id="남" value="남"> 남 
					<input type="radio" name="M_gender" id="여" value="여"> 여</li>
					<li><label for="nickname">닉네임</label> 
						<input type="text" id="M_nick" name="M_nick" size="15" required onclick="nickCheck()"> 
						<input type="button" value="중복확인"  id="joinbutton">
						
						<script type="text/javascript">
							function nickCheck() {
								window.open("MembernikCheckForm.me", "nickwin",
									"width=450, height=150");
							}
						</script>
					</li>
					
					<li><label for="email">이메일</label> 
						<input type="email" id="M_email" name="M_email" size="30"> 
						<input type="button" id="joinbutton" value="이메일 인증" onclick="location.href = 'emailSendAction.jsp'"></li>

					<li><label for="phone">전화번호</label> 
						<input type="text" id="M_phone" name="M_phone" size="15"></li>
					<li><label for="postcode">우편번호</label> <input type="text" id="sample6_postcode" placeholder="우편번호" onclick="DaumPostcode()">
						<input type="button" value="우편번호 찾기" id="joinbutton"></li>
					<li><label for="address">주소</label> <input type="text" name="M_address" id="M_address" placeholder="주소"></li>
					<li><label for="address2">상세주소</label> <input type="text" name="M_address2" id="M_address2" placeholder="상세주소"></li>
				<%@include file="addressMap.jsp"%>
			</ul>
		</fieldset>
		<!-- 기타 개인정보 입력 끝 -->
		
		<!-- 전송 버튼 -->
		<fieldset>
			<input type="submit" value="회원가입" id="joinbutton2" /> 
			<input type="reset" value="초기화" id="joinbutton3" />
		</fieldset>
		<!-- 전송 버튼 끝-->
	</form>

	<!-- 회원가입 폼 끝 -->

	<!-- ***** 푸터 시작 ***** -->
	<jsp:include page="../bottom.jsp" />
	<!-- ***** 푸터 끝 ***** -->

	<!-- jQuery -->
	<script src="assets/js/jquery-2.1.0.min.js"></script>

	<!--  Bootstrap -->
	<script src="assets/js/popper.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- Plugins -->
	<script src="assets/js/owl-carousel.js"></script>
	<script src="assets/js/accordions.js"></script>
	<script src="assets/js/datepicker.js"></script>
	<script src="assets/js/scrollreveal.min.js"></script>
	<script src="assets/js/waypoints.min.js"></script>
	<script src="assets/js/jquery.counterup.min.js"></script>
	<script src="assets/js/imgfix.min.js"></script>
	<script src="assets/js/slick.js"></script>
	<script src="assets/js/lightbox.js"></script>
	<script src="assets/js/isotope.js"></script>

	<!-- Global Init -->
	<script src="assets/js/custom.js"></script>

	<script>
		$(function() {
			var selectedClass = "";
			$("p").click(function() {
				selectedClass = $(this).attr("data-rel");
				$("#portfolio").fadeTo(50, 0.1);
				$("#portfolio div").not("." + selectedClass).fadeOut();
				setTimeout(function() {
					$("." + selectedClass).fadeIn();
					$("#portfolio").fadeTo(50, 1);
				}, 500);

			});
		});
	</script>

</body>

</html>
