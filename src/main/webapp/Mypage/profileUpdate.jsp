
<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css"> 
    <link rel="stylesheet" href="assets/css/profileupdate.css"> 
<meta charset="UTF-8">
</head>
<body>

<script type="text/javascript">
function fun1() {
	if(document.PFupdate_area.M_pw.value==""){
		alert("비밀번호를 입력하세요");
		document.PFupdate_area.M_pw.focus();
		return false;
	}
</script>

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
	 
	 <!-- ***** 제목 시작 ***** -->
	<div class="PFupdatecontainer">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-heading">
					<h2>개인 정보 수정</h2>
					<span>edit personal information</span>
				</div>
			</div>
		</div>
	</div>
	
	<!-- ***** 제목 끝 ***** --> 
	  
<%
String M_id=(String)session.getAttribute("M_id");
MemberDTO dto=(MemberDTO)request.getAttribute("dto");
%>	  
	  
<!-- ***** 개인 정보 수정 폼 시작 ***** -->
	<form action="ProfileUpdatePro.moi" method="post" id="PFupdate_area" name="PFupdate_area">
	
		<!-- 아이디 , 아이디 중복확인, 비밀번호, 비밀번호 확인 -->
		<fieldset class="PFupdateField">
			<legend>로그인 정보 확인</legend>
				<ul>
					<li><label for="userid">아이디</label> <input type="text" id="M_id" name="M_id" size="15" value="<%= dto.getM_id()%>" readonly></li>
					<li><label for="pwd1"> 비밀번호</label> <input type="password" id="M_pw" name="M_pw" size="15" placeholder="비밀번호 확인란"></li>
				</ul>
		</fieldset>
		<!-- 기타 개인정보 입력 -->
		<fieldset>
			<legend>개인 정보 수정</legend>
				<ul>
					<li><label for="fullname">이름</label> <input type="text" id="M_name" name="M_name" size="15" value="<%= dto.getM_name()%>" readonly></li>
					<li><label for="gender">성별</label> <input type="text" id="M_gender" name="M_gender" value="<%= dto.getM_gender()%>" readonly> </li>
					<li><label for="nickname">닉네임</label><input type="text" id="M_nick" name="M_nick" size="15" value="<%=dto.getM_nick()%>" readonly>
						<input type="button" value="중복확인"  id="PFcheckbutton"  onclick="nickCheck()">
						<script type="text/javascript">
							function nickCheck() {
								window.open("MembernikCheckForm.me", "nickwin",
									"width=400, height=350");
							}
						</script>
					</li>
					<li><label>이메일</label> <input type="email" id="M_email" name="M_email" size="30" value="<%= dto.getM_email()%>"></li>
					<li><label for="phone">전화번호</label> <input type="text" id="M_phone" name="M_phone" size="15" value="<%= dto.getM_phone()%>"></li>
					<li><label for="address">주소</label> <input type="text" name="M_address" id="M_address" placeholder="주소" onclick="DaumPostcode()" value="<%=dto.getM_address()%>"></li>
					<li><label for="address2">상세주소</label> <input type="text" name="M_address2" id="M_address2" placeholder="상세주소" value="<%=dto.getM_address2()%>"></li>
				<%@include file="../join/addressMap.jsp"%>
			</ul>
		</fieldset>
		<!-- 기타 개인정보 입력 끝 -->
		
		<!-- 전송 버튼 -->
		<fieldset>
			<input type="submit" value="정보 수정" id="PFupdatebutton" onclick="fun1()"/> 
		</fieldset>
		<!-- 전송 버튼 끝-->
	</form>

	<!-- 개인 정보 수정 폼 끝 -->	     
            
    
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
    <script src="../assets/js/custom.js"></script>

    <script>

        $(function() {
            var selectedClass = "";
            $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
            $("#portfolio").fadeTo(50, 0.1);
                $("#portfolio div").not("."+selectedClass).fadeOut();
            setTimeout(function() {
              $("."+selectedClass).fadeIn();
              $("#portfolio").fadeTo(50, 1);
            }, 500);
                
            });
        });

    </script> 

  </body>
</html>