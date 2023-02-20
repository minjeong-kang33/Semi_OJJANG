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
        <link rel="stylesheet" href="assets/css/mypage.css"> 
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
					<h2>마이 페이지</h2>
					<span>my page</span>
				</div>
			</div>
		</div>
	</div>
	 <!-- ***** 게시판 제목 끝 ***** -->
	 
	 
<!-- ***** 클릭 버튼 시작 ***** -->	
<div class="mypage_field">
	<button onclick="location.href='Profile.moi'"><img src="Mypage/001.png" id="MPprofile-btn"></button>
	<button onclick="location.href='WritehistoryS.moi'"><img src="Mypage/007.png" id="WritehistoryS-btn" ></button>
	<button onclick="location.href='WritehistoryB.moi'"><img src="Mypage/008.png" id="WritehistoryB-btn" ></button>
	
	<button onclick="location.href='Sellhistory.moi'"><img src="Mypage/003.png" id="MPsellhistory-btn" ></button>
	<button onclick="location.href='Buyhistory.moi'"><img src="Mypage/002.png" id="MPbuyhistory-btn" ></button>
	<button onclick="location.href='Likelist.moi'"><img src="Mypage/006.png" id="MPlike-btn" ></button>
</div>
<!-- ***** 클릭 버튼 끝 ***** -->
    
    
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