<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<head>
<meta charset="UTF-8">
<title>중고의류거래: 옺장 로그인</title>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
   integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
   crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
<link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
<link rel="stylesheet" href="assets/css/owl-carousel.css">
<link rel="stylesheet" href="assets/css/lightbox.css">
<link href="assets/css/loginForm.css" rel="stylesheet" type="text/css">
</head>
<body>
   <!-- ***** 헤더 ***** -->
   <jsp:include page="../top.jsp" />
   <!-- ***** 헤더 끝 ***** -->
   
    <!-- ***** 배너 시작 ***** -->
    <div class="page-heading about-page-heading" id="top">
        <div class="container">
             <div class="inner-content2">
                <img src="assets/images/banner_img.png" width="100%" height="80%">
             </div>
        </div>
    </div>
<!--     ***** 배너 끝 ***** -->

  <!-- ***** 게시판 제목 시작 ***** -->
   <div class="logincontainer">
      <div class="row">
         <div class="col-lg-12">
            <div class="section-heading">
               <h2>회원 로그인</h2>
               <span>Login</span>
            </div>
         </div>
      </div>
   </div>
   <!-- ***** 게시판 제목 끝 ***** -->
   
   <div class="loginFormclass">

   <form action="MemberLoginPro.me" method="post">
      <div class="form-group">
         <input type="text" class="form-control" name="M_id" id="M_id"
            aria-describedby="emailHelp" placeholder="아이디">
      </div>

      <div class="form-group">
         <input type="password" class="form-control" name="M_pw" id="M_pw"
            placeholder="비밀번호">
      </div>
      
     <div class="form-check">
         <div>
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">로그인 상태
               유지</label>
         </div>
      </div>
      
      <div class="login-button">
         <div>
            <button type="submit" class="loginbtn">로그인</button>
         </div>
      </div>
 </div>     

   </form>


   <div class="button-group">
      <div>
         <!-- 카카오 로그인 -->
         <a onclick="kakaoLogin();"> <img
            src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
            width="222" />
         </a>
      </div>
   </div>


      <div class="login-footer-info">
         <a href="" onclick="find()">아이디/비밀번호찾기   |</a> <a href="MemberJoinForm.me">회원가입</a>
         <script type="text/javascript">
            function find() {
               window.open("MemberfindIDForm.me", "nickwin",
                     "width=400, height=350");
            }
         </script>
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