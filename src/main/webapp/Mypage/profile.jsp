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
MemberDTO dto=(MemberDTO)request.getAttribute("dto");
%>      
    <!-- ***** 회원정보조회 ***** -->
    <form action="#" method="post" id="Pinfo_area">
    	<fieldset class="PinfoField">
    			<ul>
    				<li><label for="userid">아이디</label><span><%=dto.getM_id() %></span></li>
    				<li><label for="username">이름</label><span><%=dto.getM_name() %></span></li>
    				<li><label for="usernick">닉네임</label><span><%=dto.getM_nick() %></span></li>
    				<li><label for="usergender">성별</label><span><%=dto.getM_gender() %></span></li>
    				<li><label for="useremail">이메일</label><span><%=dto.getM_email() %></span></li>
    				<li><label for="useraddr">주소</label><span><%=dto.getM_address()+" "+dto.getM_address2()%></span></li>
	    			<li><a href="MemberwithdrawalForm.me">회원탈퇴</a></li>
    			</ul>
    	</fieldset>
    </form>
    	
<%-- <div class="page-heading about-page-heading" id="top">
     <div class="container">
         <div class="inner-content2"> 
         
    <section>


아이디: <%=dto.getM_id() %><br>
이름: <%=dto.getM_name() %><br>
닉네임: <%=dto.getM_nick() %><br>
이메일: <%=dto.getM_email() %><br>
주소: <%=dto.getM_address() %><br>
상세주소: <%=dto.getM_address2() %><br>
번호: <%=dto.getM_phone() %><br>
성별: <%=dto.getM_gender() %><br>

<button onclick="location.href='ProfileUpdateForm.moi'">프로필 수정</button>
<button onclick="location.href='PwUpdateForm.moi'">비밀번호 수정</button>

</section>

             </div>
        </div>
    </div> --%>
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