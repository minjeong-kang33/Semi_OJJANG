<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<%
String M_id = (String) session.getAttribute("M_id");
%>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css"> 
    <link rel="stylesheet" href="assets/css/withdrawal.css"> 
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
	<div class="withdrawalcontainer">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-heading">
					<h2>회원탈퇴</h2>
					<span>membership withdrawal</span>
				</div>
			</div>
		</div>
	</div>
	<!-- ***** 게시판 제목 끝 ***** -->
	
	<div class="withdrawal_div">
	<form action="MemberwithdrawalPro.me" onsubmit="return withdrawCheck()" method="post" name="withdrawal_area" id="withdrawal_area">
		<fieldset class="withdrawalField">
			<ul>
				<li><label>아이디</label> <input type="text" id="M_id" name="M_id" size="15" value="<%= M_id%>" readonly></li>
				<li><label for="pwd1"> 비밀번호</label> <input type="password" id="M_pw" name="M_pw" size="15" placeholder="비밀번호 확인란" required></li>
				<li><label for="pwd1"> 탈퇴사유</label><select name="re" id="re">
														<option value="0">선택하세요.</option>
														<option value="1">원하는 상품이 없어요.</option>
														<option value="2">비매너 사용자를 만났어요.</option>
														<option value="3">물품이 안팔려요.</option>
														<option value="4"> 기타 </option>
													 </select>
<script type="text/javascript">
	function withdrawCheck(){
	let M_pw = document.getElementById("M_pw").value;
	M_pw = M_pw.trim();
	let message="진행된 내용은 복구되지 않습니다. \n계속 진행 할까요?";
	if(confirm(message)){
		return true;
		else{
			return false
		}
	}
}
</script>
			</ul>
		<input type="submit" value="회원탈퇴" id="withdrawalbtn">
	</fieldset>
	</form>
	</div>
	
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