
<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/font-awesome.css">
    <link rel="stylesheet" href="../assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="../assets/css/owl-carousel.css">
    <link rel="stylesheet" href="../assets/css/lightbox.css"> 
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>
</head>
<body>
    <body>

    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
     <div class="page-heading about-page-heading" id="top">
        <div class="container">
             <div class="inner-content2">
             	
    <!-- ***** 회원정보수정 ***** -->


<h3>회원정보수정</h3>	

<%
String M_id=(String)session.getAttribute("M_id");
MemberDAO dao=new MemberDAO();
MemberDTO dto=dao.getMember(M_id);
%>
<section>	
<form action="profileUpdatepro.jsp" method="post">
아이디 : <input type="text" name="M_id" value="<%=M_id%>" readonly><br>
비밀번호 : <input type="password" name="M_pw"><br>
이름 : <input type="text" name="M_name" value="<%=dto.getM_name()%>" readonly><br>
닉네임: <input type="text" name="M_nick" value="<%=dto.getM_nick()%>"><br>
전화번호: <input type="text" name="M_phone" value="<%=dto.getM_phone() %>" readonly><br>
주소: <input type="text" name="M_address" value="<%=dto.getM_address() %>"> <br>
상세주소:<input type="text" name="M_address2" value="<%=dto.getM_address2() %>"><br>
이메일:<input type="text" name="M_email" value="<%=dto.getM_email() %>"><br>

<input type="submit" value="회원정보수정">
</form>

<a href="main.jsp">메인으로 이동</a>

</section>
               
	<!-- ***** 회원정보수정 끝 ***** -->        
            
             </div>
        </div>
    </div>
    
       <!-- ***** 푸터 시작 ***** -->
   <jsp:include page="../bottom.jsp" />
    <!-- ***** 푸터 끝 ***** -->

 <!-- jQuery -->
    <script src="../assets/js/jquery-2.1.0.min.js"></script>

 <!--  Bootstrap -->
    <script src="../assets/js/popper.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>

 <!-- Plugins -->
    <script src="../assets/js/owl-carousel.js"></script>
    <script src="../assets/js/accordions.js"></script>
    <script src="../assets/js/datepicker.js"></script>
    <script src="../assets/js/scrollreveal.min.js"></script>
    <script src="../assets/js/waypoints.min.js"></script>
    <script src="../assets/js/jquery.counterup.min.js"></script>
    <script src="../assets/js/imgfix.min.js"></script> 
    <script src="../assets/js/slick.js"></script> 
    <script src="../assets/js/lightbox.js"></script> 
    <script src="../assets/js/isotope.js"></script> 
    
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