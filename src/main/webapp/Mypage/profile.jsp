<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
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
    <link rel="stylesheet" href="assets/css/profile.css"> 
<meta charset="UTF-8">
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
					<h2>개인 정보 조회</h2>
					<span>personal information</span>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** 게시판 제목 끝 ***** -->
	
 <%
String M_id=(String)session.getAttribute("M_id");
MemberDAO  dao=new MemberDAO();
MemberDTO dto=dao.getMember(M_id);


%>      
    <!-- ***** 회원정보조회 ***** -->
    <form action="#" method="post" id="profile_area">
    	<fieldset class="profileField">
    			<ul>
    				<li><label>아이디</label> <input type="text" id="M_id" name="M_id" size="15" value="<%= dto.getM_id()%>" readonly></li>
    				<li><label>이름</label> <input type="text" id="M_name" name="M_name" size="15" value="<%= dto.getM_name()%>" readonly></li>
    				<li><label>닉네임</label> <input type="text" id="M_nick" name="M_nick" size="15" value="<%=dto.getM_nick()%>" readonly></li>
    				<li><label>성별</label> <input type="text" id="M_gender" name="M_gender" value="<%= dto.getM_gender()%>" readonly> </li>
    				<li><label>이메일</label> <input type="email" id="M_email" name="M_email" size="30" value="<%= dto.getM_email()%>" readonly></li>
    				<li><label>주소</label> <input type="text" name="M_address" id="M_address12" value="<%= dto.getM_address()+" "+dto.getM_address2()%>" readonly></li>
    			</ul>
    	</fieldset>
    </form>
       <fieldset class="btnss">
    		<button id="profileupdate-btn" onclick="location.href='ProfileUpdateForm.moi'">개인정보 변경</button>
			<button id="pwupdate-btn" onclick="location.href='PwUpdateForm.moi'">비밀번호 변경</button>
			<button id="withdraw-btn" onclick="location.href='MemberwithdrawalForm.me'">회원탈퇴</button>
    	</fieldset>
    
	<!-- ***** 회원정보조회 끝 ***** -->
	
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