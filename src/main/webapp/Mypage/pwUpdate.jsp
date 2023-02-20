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
    <link rel="stylesheet" href="assets/css/pwUpdate.css"> 
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
	<div class="PWchangecontainer">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-heading">
					<h2>비밀번호 변경</h2>
					<span>password change</span>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** 게시판 제목 끝 ***** --> 
	
<%
String M_id=(String)session.getAttribute("M_id");
%>     

    <!-- ***** 비밀번호 수정 시작 ***** -->

<form action="PwUpdatePro.moi" method="post" name="PWchange_area" id="PWchange_area">
	<fieldset class="PWchangeField">
		<ul>
			<li><label>아이디</label> <input type="text" id="M_id" name="M_id" size="15" value="<%= M_id%>" readonly></li>
			<li><label>현재 비밀번호</label> <input type="password" id="M_pw" name="M_pw" size="15" required placeholder="비밀번호 확인용"></li>
			<li><label>새 비밀번호</label> <input type="password" id="M_pw2" name="M_pw2" size="15" required placeholder="새로운 비밀번호"></li>
		</ul>
	</fieldset>
</form>
	<fieldset>
		<input type="button" value="비밀번호 변경" onclick="fun1()" id="PWupdatebtn">
	</fieldset>

	<!-- ***** 비밀번호수정 끝 ***** -->        
            
    
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
	 <script>
  function fun1(){
		if(document.PWchange_area.M_pw2.value.length<6){
			alert("비밀번호를 6자 이상 입력하세요.")
			document.PWchange_area.M_pw2.focus();
			return;
		}
		document.PWchange_area.submit();
	}
  </script>
  
  </body>
</html>  
